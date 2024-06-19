package com.example.geodude.util

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class ConstantTest {
	@Test
	fun testGetQuestionList() {
		val questions = Constant.getQuestionList()
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