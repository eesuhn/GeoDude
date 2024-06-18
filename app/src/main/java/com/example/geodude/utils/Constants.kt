package com.example.geodude.utils

import com.example.geodude.R
import com.example.geodude.model.Question

object Constants {
	private val flagData = listOf(
		Pair(R.drawable.ae, "United Arab Emirates"),
		Pair(R.drawable.af, "Afghanistan"),
		Pair(R.drawable.am, "Armenia"),
		Pair(R.drawable.ao, "Angola"),
		Pair(R.drawable.ar, "Argentina"),
		Pair(R.drawable.at, "Austria"),
		Pair(R.drawable.au, "Australia"),
		Pair(R.drawable.ba, "Bosnia and Herzegovina"),
		Pair(R.drawable.bb, "Barbados"),
		Pair(R.drawable.bd, "Bangladesh"),
		Pair(R.drawable.be, "Belgium"),
		Pair(R.drawable.bf, "Burkina Faso"),
		Pair(R.drawable.bg, "Bulgaria"),
		Pair(R.drawable.bh, "Bahrain"),
		Pair(R.drawable.bj, "Benin"),
		Pair(R.drawable.bn, "Brunei"),
		Pair(R.drawable.bo, "Bolivia"),
		Pair(R.drawable.br, "Brazil"),
		Pair(R.drawable.ca, "Canada"),
		Pair(R.drawable.ch, "Switzerland"),
		Pair(R.drawable.cn, "China"),
		Pair(R.drawable.co, "Colombia"),
		Pair(R.drawable.cr, "Costa Rica"),
		Pair(R.drawable.cu, "Cuba"),
		Pair(R.drawable.cy, "Cyprus"),
		Pair(R.drawable.cz, "Czech Republic"),
		Pair(R.drawable.de, "Germany"),
		Pair(R.drawable.dk, "Denmark"),
		Pair(R.drawable.dm, "Dominica"),
		Pair(R.drawable.dz, "Algeria"),
		Pair(R.drawable.ee, "Estonia"),
		Pair(R.drawable.eg, "Egypt"),
		Pair(R.drawable.er, "Eritrea"),
		Pair(R.drawable.es, "Spain"),
		Pair(R.drawable.et, "Ethiopia"),
		Pair(R.drawable.fi, "Finland"),
		Pair(R.drawable.fj, "Fiji"),
		Pair(R.drawable.fr, "France"),
		Pair(R.drawable.gb, "United Kingdom"),
		Pair(R.drawable.ge, "Georgia"),
		Pair(R.drawable.gh, "Ghana"),
		Pair(R.drawable.gl, "Greenland"),
		Pair(R.drawable.gn, "Guinea"),
		Pair(R.drawable.gr, "Greece"),
		Pair(R.drawable.gt, "Guatemala"),
		Pair(R.drawable.gy, "Guyana"),
		Pair(R.drawable.hn, "Honduras"),
		Pair(R.drawable.hr, "Croatia"),
		Pair(R.drawable.ht, "Haiti"),
		Pair(R.drawable.hu, "Hungary"),
		Pair(R.drawable.id, "Indonesia"),
		Pair(R.drawable.ie, "Ireland"),
		Pair(R.drawable.iq, "Iraq"),
		Pair(R.drawable.ir, "Iran"),
		Pair(R.drawable.it, "Italy"),
		Pair(R.drawable.jm, "Jamaica"),
		Pair(R.drawable.jo, "Jordan"),
		Pair(R.drawable.jp, "Japan"),
		Pair(R.drawable.ke, "Kenya"),
		Pair(R.drawable.kh, "Cambodia"),
		Pair(R.drawable.kp, "North Korea"),
		Pair(R.drawable.la, "Laos"),
		Pair(R.drawable.lb, "Lebanon"),
		Pair(R.drawable.lk, "Sri Lanka"),
		Pair(R.drawable.lr, "Liberia"),
	)

	/**
	 * Get a list of 10 random questions, with random options and answers
	 */
	fun getQuestions(): List<Question> {
		val questions = mutableListOf<Question>()
		val flagDataCopy = flagData.toMutableList()

		for (i in 1..10) {
			val randomIndex = (0 until flagDataCopy.size).random()
			val (flag, country) = flagDataCopy[randomIndex]
			val options = mutableListOf<String>()
			options.add(country)

			// Generate 3 other random options
			while (options.size < 4) {
				val randomOptionIndex = (0 until flagDataCopy.size).random()
				val randomOption = flagDataCopy[randomOptionIndex].second
				if (!options.contains(randomOption)) {
					options.add(randomOption)
				}
			}
			options.shuffle()

			val correctAnswerIndex = options.indexOf(country)
			questions.add(Question(
				id = i,
				question = "What country does this flag belong to?",
				image = flag,
				options = options,
				correctAnswer = correctAnswerIndex
			))

			// Remove used flag data to avoid repetition
			flagDataCopy.removeAt(randomIndex)
		}
		return questions
	}
}