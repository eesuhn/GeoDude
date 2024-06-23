package com.example.geodude.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.geodude.R
import com.example.geodude.model.AttemptModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {

	private lateinit var sharedPreferences: SharedPreferences
	private val attemptsKey = "attempts"

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_result)

		sharedPreferences = getSharedPreferences("GeoDudePrefs", Context.MODE_PRIVATE)

		val resultText: TextView = findViewById(R.id.resultText)
		val cheatText: TextView = findViewById(R.id.cheatUsed)
		displayScore(resultText, cheatText)

		val restartButton: Button = findViewById(R.id.restartBtn)
		checkRestartBtn(restartButton)

		val viewScoresButton: Button = findViewById(R.id.viewScoresBtn)
		checkViewScoresBtn(viewScoresButton)

		saveCurrentAttempt()
	}

	private fun saveCurrentAttempt() {
		val playerName = intent.getStringExtra("playerName") ?: "Unknown"
		val score = intent.getIntExtra("score", 0)
		val date = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Date())

		val newAttempt = AttemptModel(playerName, score, date)
		addNewAttempt(newAttempt)
	}

	private fun addNewAttempt(newAttempt: AttemptModel) {
		val attempts = getPastAttempts().toMutableList()
		attempts.add(newAttempt)
		savePastAttempts(attempts)
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

	private fun savePastAttempts(attempts: List<AttemptModel>) {
		val gson = Gson()
		val json = gson.toJson(attempts)
		sharedPreferences.edit().putString(attemptsKey, json).apply()
	}

	@SuppressLint("StringFormatMatches")
	private fun displayScore(resultText: TextView, cheatText: TextView) {
		val score = intent.getIntExtra("score", 0)
		val cheatCount = intent.getIntExtra("cheatCount", 0)
		resultText.text = getString(R.string.score_result, score)
		cheatText.text = getString(R.string.cheat_used, cheatCount)
	}

	private fun checkRestartBtn(restartButton: Button) {
		restartButton.setOnClickListener {
			val intent = Intent(this, MainActivity::class.java)
			intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
			startActivity(intent)
			overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
			finish()
		}
	}

	private fun checkViewScoresBtn(viewScoresButton: Button) {
		viewScoresButton.setOnClickListener {
			val intent = Intent(this, ScoreActivity::class.java)
			startActivity(intent)
			overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
		}
	}
}