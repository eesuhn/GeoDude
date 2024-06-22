package com.example.geodude.activity

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geodude.R
import com.example.geodude.model.QuestionModel
import com.example.geodude.util.Constant

class QuestionActivity : AppCompatActivity() {

	private lateinit var questionList: List<QuestionModel>
	private var currentQuestionIndex: Int = 0
	private var score: Int = 0
	private lateinit var selectedAnswers: MutableList<Int?>

	private lateinit var progressBar: ProgressBar
	private lateinit var countryFlag: ImageView
	private lateinit var optionButtons: List<Button>
	private lateinit var prevBtn: ImageView
	private lateinit var nextBtn: ImageView

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContentView(R.layout.activity_question)

		questionList = Constant.getQuestionList()
		selectedAnswers = MutableList(questionList.size) { null }

		progressBar = findViewById(R.id.progressBar)
		countryFlag = findViewById(R.id.countryFlag)
		optionButtons = listOf(
			findViewById(R.id.optionOne),
			findViewById(R.id.optionTwo),
			findViewById(R.id.optionThree),
			findViewById(R.id.optionFour)
		)
		prevBtn = findViewById(R.id.prevBtn)
		nextBtn = findViewById(R.id.nextBtn)

		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
			insets
		}

		prevBtn.setOnClickListener { navigateToPreviousQuestion() }
		nextBtn.setOnClickListener { navigateToNextQuestion() }
		optionButtons.forEachIndexed { index, button ->
			button.setOnClickListener { handleOptionSelected(index) }
		}

		displayQuestion()
	}

	private fun displayQuestion() {
		val currentQuestion = questionList[currentQuestionIndex]
		countryFlag.setImageResource(currentQuestion.image)
		optionButtons.forEachIndexed { index, button ->
			button.text = currentQuestion.options[index]
			if (selectedAnswers[currentQuestionIndex] == index) {
				button.setBackgroundResource(R.drawable.bg_btn_selected)
				button.setTextColor(resources.getColor(R.color.on_accent))
			} else {
				button.setBackgroundResource(R.drawable.bg_btn)
				button.setTextColor(resources.getColor(R.color.on_logo))
			}
		}
		updateProgressBar()
	}

	private fun handleOptionSelected(selectedIndex: Int) {
		selectedAnswers[currentQuestionIndex] = selectedIndex
		updateScore()
		displayQuestion()
		navigateToNextQuestion()
	}

	private fun updateScore() {
		score = 0
		selectedAnswers.forEachIndexed { index, answer ->
			if (answer == questionList[index].correctAnswer) {
				score++
			}
		}
	}

	private fun navigateToPreviousQuestion() {
		if (currentQuestionIndex > 0) {
			currentQuestionIndex--
			displayQuestion()
		}
	}

	private fun navigateToNextQuestion() {
		if (currentQuestionIndex < questionList.size - 1) {
			currentQuestionIndex++
			displayQuestion()
		} else {
			val intent = Intent(this, ResultActivity::class.java)
			intent.putExtra("score", score)
			startActivity(intent)
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
			finish()
		}
	}

	private fun updateProgressBar() {
		val progress = (currentQuestionIndex / questionList.size.toFloat() * 100).toInt()
		progressBar.progress = progress
	}
}