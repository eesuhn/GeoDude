package com.example.geodude.model

data class QuestionModel(
	val id: Int,
	val image: Int,
	val options: List<String>,
	val correctAnswer: Int
)