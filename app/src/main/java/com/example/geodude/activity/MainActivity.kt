package com.example.geodude.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.geodude.R

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val startBtn: Button = findViewById(R.id.startBtn)
		val nameInput: EditText = findViewById(R.id.nameInput)
		checkStartBtn(startBtn, nameInput)

		val viewScoresButton: Button = findViewById(R.id.viewScoresBtn)
		checkViewScoresBtn(viewScoresButton)
	}

	private fun checkStartBtn(startBtn: Button, nameInput: EditText) {
		startBtn.setOnClickListener {
			val name = nameInput.text.toString()
			if (name.isNotEmpty()) {
				Intent(this@MainActivity, QuestionActivity::class.java).also {
					it.putExtra("playerName", name)
					startActivity(it)
					overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
					finish()
				}
			} else {
				Toast.makeText(this@MainActivity, "Please enter your name", Toast.LENGTH_LONG).show()
			}
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