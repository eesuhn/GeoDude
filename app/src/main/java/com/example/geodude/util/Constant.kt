package com.example.geodude.util

import com.example.geodude.R
import com.example.geodude.model.QuestionModel

object Constant {
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
		Pair(R.drawable.lt, "Lithuania"),
		Pair(R.drawable.lu, "Luxembourg"),
		Pair(R.drawable.lv, "Latvia"),
		Pair(R.drawable.ly, "Libya"),
		Pair(R.drawable.ma, "Morocco"),
		Pair(R.drawable.md, "Moldova"),
		Pair(R.drawable.me, "Montenegro"),
		Pair(R.drawable.mg, "Madagascar"),
		Pair(R.drawable.mk, "Macedonia"),
		Pair(R.drawable.ml, "Mali"),
		Pair(R.drawable.mm, "Myanmar"),
		Pair(R.drawable.mn, "Mongolia"),
		Pair(R.drawable.mr, "Mauritania"),
		Pair(R.drawable.mt, "Malta"),
		Pair(R.drawable.mu, "Mauritius"),
		Pair(R.drawable.mv, "Maldives"),
		Pair(R.drawable.mw, "Malawi"),
		Pair(R.drawable.mx, "Mexico"),
		Pair(R.drawable.my, "Malaysia"),
		Pair(R.drawable.na, "Namibia"),
		Pair(R.drawable.ne, "Niger"),
		Pair(R.drawable.ng, "Nigeria"),
		Pair(R.drawable.ni, "Nicaragua"),
		Pair(R.drawable.nl, "Netherlands"),
		Pair(R.drawable.no, "Norway"),
		Pair(R.drawable.np, "Nepal"),
		Pair(R.drawable.nz, "New Zealand"),
		Pair(R.drawable.om, "Oman"),
		Pair(R.drawable.pa, "Panama"),
		Pair(R.drawable.pe, "Peru"),
		Pair(R.drawable.pg, "Papua New Guinea"),
		Pair(R.drawable.ph, "Philippines"),
		Pair(R.drawable.pk, "Pakistan"),
		Pair(R.drawable.pl, "Poland"),
		Pair(R.drawable.pm, "Saint Pierre and Miquelon"),
		Pair(R.drawable.pr, "Puerto Rico"),
		Pair(R.drawable.pt, "Portugal"),
		Pair(R.drawable.py, "Paraguay"),
		Pair(R.drawable.qa, "Qatar"),
		Pair(R.drawable.ro, "Romania"),
		Pair(R.drawable.rs, "Serbia"),
		Pair(R.drawable.ru, "Russia"),
		Pair(R.drawable.rw, "Rwanda"),
		Pair(R.drawable.sa, "Saudi Arabia"),
		Pair(R.drawable.sd, "Sudan"),
		Pair(R.drawable.se, "Sweden"),
		Pair(R.drawable.sg, "Singapore"),
		Pair(R.drawable.si, "Slovenia"),
		Pair(R.drawable.sk, "Slovakia"),
		Pair(R.drawable.sl, "Sierra Leone"),
		Pair(R.drawable.sn, "Senegal"),
		Pair(R.drawable.so, "Somalia"),
		Pair(R.drawable.sr, "Suriname"),
		Pair(R.drawable.ss, "South Sudan"),
		Pair(R.drawable.sv, "El Salvador"),
		Pair(R.drawable.sy, "Syria"),
		Pair(R.drawable.sz, "Swaziland"),
		Pair(R.drawable.th, "Thailand"),
		Pair(R.drawable.tj, "Tajikistan"),
		Pair(R.drawable.tl, "East Timor"),
		Pair(R.drawable.tm, "Turkmenistan"),
		Pair(R.drawable.tn, "Tunisia"),
		Pair(R.drawable.tr, "Turkey"),
		Pair(R.drawable.tt, "Trinidad and Tobago"),
		Pair(R.drawable.tw, "Taiwan"),
		Pair(R.drawable.tz, "Tanzania"),
		Pair(R.drawable.ua, "Ukraine"),
		Pair(R.drawable.ug, "Uganda"),
		Pair(R.drawable.us, "United States"),
		Pair(R.drawable.uy, "Uruguay"),
		Pair(R.drawable.uz, "Uzbekistan"),
		Pair(R.drawable.ve, "Venezuela"),
		Pair(R.drawable.vn, "Vietnam"),
		Pair(R.drawable.vu, "Vanuatu"),
		Pair(R.drawable.ws, "Samoa"),
		Pair(R.drawable.xk, "Kosovo"),
		Pair(R.drawable.ye, "Yemen"),
		Pair(R.drawable.za, "South Africa"),
		Pair(R.drawable.zm, "Zambia"),
		Pair(R.drawable.zw, "Zimbabwe")
	)

	/**
	 * Get a list of 10 random questions, with random options and answers
	 * @return List of [QuestionModel]
	 */
	fun getQuestionList(): List<QuestionModel> {
		val questionList = mutableListOf<QuestionModel>()
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
			questionList.add(QuestionModel(
				id = i,
				image = flag,
				options = options,
				correctAnswer = correctAnswerIndex
			))

			// Remove used flag data to avoid repetition
			flagDataCopy.removeAt(randomIndex)
		}
		return questionList
	}
}