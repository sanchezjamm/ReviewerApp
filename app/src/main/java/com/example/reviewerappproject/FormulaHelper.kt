package com.example.reviewerappproject

import kotlin.random.Random


class FormulaHelper {
    companion object {
        private fun getFormula(): Int{
            return Random.nextInt(1,11)
        }
        fun shuffleFormula(): IntArray{
            return intArrayOf(
                getFormula(),
                getFormula(),
                getFormula(),
                getFormula(),
                getFormula(),
                getFormula(),
                getFormula(),
                getFormula(),
                getFormula(),
                getFormula(),
            )

        }

    }
}