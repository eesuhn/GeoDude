package com.example.geodude.utils

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class ConstantsTest {
	@Test
	fun testGetQuestions() {
		val questions = Constants.getQuestions()
		assertEquals(10, questions.size)

		questions.forEachIndexed { index, question ->
			println("\n--------------------------------------------------")
			println("Question ${index + 1}: ${question.question}")
			println("Options: ${question.options}")
			println("Correct Answer: ${question.options[question.correctAnswer]}")
			println("Image: ${question.image}")
			println("--------------------------------------------------\n")
		}
	}
}