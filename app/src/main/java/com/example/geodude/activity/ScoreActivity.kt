package com.example.geodude.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.geodude.R
import com.example.geodude.model.AttemptModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.Locale

class ScoreActivity : AppCompatActivity() {

	private lateinit var sharedPreferences: SharedPreferences
	private val attemptsKey = "attempts"

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_score)

		sharedPreferences = getSharedPreferences("GeoDudePrefs", Context.MODE_PRIVATE)

		val attemptsLayout: LinearLayout = findViewById(R.id.attemptsLayout)
		val backBtn: Button = findViewById(R.id.backBtn)

		val attempts = getPastAttempts()
		displayAttempts(attempts, attemptsLayout)

		checkBackBtn(backBtn)
	}

	private fun checkBackBtn(backBtn: Button) {
		backBtn.setOnClickListener {
			finish()
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
		}
	}

	private fun getPastAttempts(): List<AttemptModel> {
		val gson = Gson()
		val json = sharedPreferences.getString(attemptsKey, null)
		return if (json != null) {
			val type = object : TypeToken<List<AttemptModel>>() {}.type
			gson.fromJson(json, type)
		} else {
			listOf()
		}
	}

	@SuppressLint("InflateParams")
	private fun displayAttempts(attempts: List<AttemptModel>, attemptsLayout: LinearLayout) {
		val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
		val outputFormat = SimpleDateFormat("HH:mm, d MMM", Locale.getDefault())

		val sortedAttempts = attempts.sortedByDescending { inputFormat.parse(it.date) }

		sortedAttempts.forEach { attempt ->
			val attemptView = layoutInflater.inflate(R.layout.score_item, null)

			val playerNameText: TextView = attemptView.findViewById(R.id.playerNameText)
			val scoreText: TextView = attemptView.findViewById(R.id.scoreText)
			val dateText: TextView = attemptView.findViewById(R.id.dateText)

			playerNameText.text = attempt.playerName
			scoreText.text = attempt.score.toString()

			val date = inputFormat.parse(attempt.date)
			val formattedDate = date?.let { outputFormat.format(it) } ?: attempt.date
			dateText.text = formattedDate

			attemptsLayout.addView(attemptView)
		}
	}

	/**
	 * @deprecated Not used in current implementation
	 */
	private fun addNewAttempt(newAttempt: AttemptModel) {
		val attempts = getPastAttempts().toMutableList()
		attempts.add(newAttempt)
		savePastAttempts(attempts)
	}

	/**
	 * @deprecated Not used in current implementation
	 */
	private fun savePastAttempts(attempts: List<AttemptModel>) {
		val gson = Gson()
		val json = gson.toJson(attempts)
		sharedPreferences.edit().putString(attemptsKey, json).apply()
	}
}