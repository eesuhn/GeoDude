package com.example.geodude.utils

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class ConstantsTest {
	@Test
	fun testGetQuestionList() {
		val questions = Constants.getQuestionList()
		assertEquals(10, questions.size)

		questions.forEachIndexed { index, question ->
			println("\n--------------------------------------------------")
			println("Question ${index + 1}:")
			println("Options: ${question.options}")
			println("Correct Answer: ${question.options[question.correctAnswer]}")
			println("Image: ${question.image}")
			println("--------------------------------------------------\n")
		}
	}
}