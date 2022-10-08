package com.example.reviewerappproject

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.reviewerappproject.databinding.ActivityDisplayformulasBinding

class DisplayFormula : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDisplayformulasBinding
    private lateinit var sharedPreferences: SharedPreferences

    private val imageViews by lazy {
        arrayListOf(
            binding.imgShowFormula
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayformulasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
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
                1 -> R.drawable.background
                2 -> R.drawable.defterms
                3 -> R.drawable.defterms_bg
                4 -> R.drawable.formulas
                5 -> R.drawable.formulas_bg
                6 -> R.drawable.shuffle
                7 -> R.drawable.testyourself
                8 -> R.drawable.shuffle
                9 -> R.drawable.testyourself
                10 -> R.drawable.defterms
                else -> R.drawable.background

            }
            imageViews[i].setImageResource(drawableId)
        }
    }
}

