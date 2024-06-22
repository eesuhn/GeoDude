package com.example.geodude.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geodude.R

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContentView(R.layout.activity_main)

		val startBtn: Button = findViewById(R.id.startBtn)
		val nameInput: EditText = findViewById(R.id.nameInput)
		val viewScoresButton: Button = findViewById(R.id.viewScoresBtn)

		checkStartBtn(startBtn, nameInput)
		checkViewScoresBtn(viewScoresButton)

		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
			insets
		}
	}

	private fun checkStartBtn(startBtn: Button, nameInput: EditText) {
		startBtn.setOnClickListener {
			val name = nameInput.text.toString()
			if (name.isNotEmpty()) {
				Intent(this@MainActivity, QuestionActivity::class.java).also {
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