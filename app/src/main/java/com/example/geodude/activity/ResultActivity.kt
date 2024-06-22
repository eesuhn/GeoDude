package com.example.geodude.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.geodude.R

class ResultActivity : AppCompatActivity() {

	@SuppressLint("StringFormatMatches")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_result)

		val score = intent.getIntExtra("score", 0)
		val resultText: TextView = findViewById(R.id.resultText)
		resultText.text = getString(R.string.result_score, score)

		val restartButton: Button = findViewById(R.id.restartBtn)
		restartButton.setOnClickListener {
			val intent = Intent(this, MainActivity::class.java)
			intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
			startActivity(intent)
			finish()
		}
	}
}