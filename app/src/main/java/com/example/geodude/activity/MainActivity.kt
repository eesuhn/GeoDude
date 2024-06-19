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

		checkStartBtn(startBtn, nameInput)

		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
			insets
		}
	}

	/**
	 * Check if the start button is clicked and if the name input is not empty
	 */
	private fun checkStartBtn(startBtn: Button, nameInput: EditText) {
		startBtn.setOnClickListener {
			val name = nameInput.text.toString()
			if (name.isNotEmpty()) {
				Intent(this@MainActivity, QuestionActivity::class.java).also {
					startActivity(it)
					finish()
				}
			} else {
				Toast.makeText(this@MainActivity, "Please enter your name", Toast.LENGTH_LONG).show()
			}
		}
	}
}