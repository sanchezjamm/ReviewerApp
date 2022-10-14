package com.example.reviewerappproject

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.reviewerappproject.databinding.ActivityDisplayformulasBinding

class DisplayFormula : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDisplayformulasBinding

    private val imageViews by lazy {
        arrayListOf(
            binding.imgShowFormula
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayformulasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnShuffleform.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            (R.id.btn_shuffleform) -> {
                val formulaResult = FormulaHelper.shuffleFormula()
                displayFormula(formulaResult)
            }

        }
    }

    private fun displayFormula(intArray: IntArray) {
        for (i in imageViews.indices) {
            val drawableId = when (intArray[i]) {
                1 -> R.drawable.slide1
                2 -> R.drawable.slide2
                3 -> R.drawable.slide3
                4 -> R.drawable.slide4
                5 -> R.drawable.slide5
                6 -> R.drawable.slide6
                7 -> R.drawable.slide7
                8 -> R.drawable.slide8
                9 -> R.drawable.slide9
                10 -> R.drawable.slide10
                else -> R.drawable.slide1

            }
            imageViews[i].setImageResource(drawableId)
        }
    }
}

