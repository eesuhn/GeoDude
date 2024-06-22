package com.example.geodude.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.geodude.R

class ResultActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_result)

		val resultText: TextView = findViewById(R.id.resultText)
		val restartButton: Button = findViewById(R.id.restartBtn)

		displayScore(resultText)
		checkRestartBtn(restartButton)
	}

	@SuppressLint("StringFormatMatches")
	private fun displayScore(resultText: TextView) {
		val score = intent.getIntExtra("score", 0)
		resultText.text = getString(R.string.result_score, score)
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
}