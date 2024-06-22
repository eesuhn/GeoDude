package com.example.geodude.util

import android.util.Log
import com.example.geodude.model.QuestionModel
import com.example.geodude.network.RetrofitInstance

data class FlagData(val code: String, val country: String)

object Constant {
	private const val BASE_FLAG_URL = "https://flagcdn.com/256x192/"

	suspend fun fetchFlagData(): List<FlagData> {
		Log.d("FlagAPI", "Fetching flag data...")
		val flagCodes = RetrofitInstance.api.getFlagCodes()
		Log.d("FlagAPI", "Received flag codes: ${flagCodes.size}")
		return flagCodes.map { (code, country) -> FlagData(code, country) }
	}

	fun getQuestionList(flagData: List<FlagData>): List<QuestionModel> {
		val questionList = mutableListOf<QuestionModel>()
		val flagDataCopy = flagData.toMutableList()

		for (i in 1..10) {
			val randomIndex = (0 until flagDataCopy.size).random()
			val (code, country) = flagDataCopy[randomIndex]
			val flagUrl = "$BASE_FLAG_URL$code.png"
			val options = mutableListOf<String>()
			options.add(country)

			// Generate 3 other random options
			while (options.size < 4) {
				val randomOptionIndex = (0 until flagDataCopy.size).random()
				val randomOption = flagDataCopy[randomOptionIndex].country
				if (!options.contains(randomOption)) {
					options.add(randomOption)
				}
			}
			options.shuffle()

			val correctAnswerIndex = options.indexOf(country)
			questionList.add(QuestionModel(
				id = i,
				image = flagUrl,
				options = options,
				correctAnswer = correctAnswerIndex
			))

			// Remove used flag data to avoid repetition
			flagDataCopy.removeAt(randomIndex)
		}
		return questionList
	}
}