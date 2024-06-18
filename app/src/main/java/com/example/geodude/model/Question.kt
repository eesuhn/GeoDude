package com.example.geodude.model

data class Question(
	val id: Int,
	val image: Int,
	val options: List<String>,
	val correctAnswer: Int
)