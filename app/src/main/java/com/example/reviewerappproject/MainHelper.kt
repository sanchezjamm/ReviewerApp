package com.example.reviewerappproject

import kotlin.random.Random

class MainHelper {
    companion object {
        fun getCategory ():Int {
            return Random.nextInt(1,3)
        }

        fun getReviewerApp (category:Int):String {
            return when (category) {
                1 -> {DefTermsHelper.displayDefTerms()}
                else -> {DefTermsHelper.displayDefTerms()
                }

            }
        }
    }}
