package com.example.geodude.model

data class QuestionModel(
	val id: Int,
	val image: String,
	val options: List<String>,
	val correctAnswer: Int
)