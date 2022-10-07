package com.example.reviewerappproject

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.example.reviewerappproject.databinding.ActivityMainBinding
import kotlin.random.Random

class QuizHelper(context: Context) {

    private var quizHelperInterface: QuestionsInterface

    interface QuestionsInterface {
        fun getQuestion(question: String, answersList: List<String>, correctAnswerIndex: Int)
    }

    init {
        quizHelperInterface = context as QuestionsInterface
    }

    //LIST OF QUESTIONS
    private val questions = mapOf(
        Pair(1, "In a class A transformer-coupled amplifier, the the value of VCEmax and the the value of VCEmin, the efficiency to (from) the theoretical limit of 50%."),
        Pair(2, "Question 2"),
        Pair(3, "Question 3"),
        Pair(4, "Question 4"),
        Pair(5, "Question 5"),
        Pair(6, "Question 6")
    )

    //LIST OF ANSWERS TO A SPECIFIC QUESTION EXAMPLE: IF IT's QUESTION 1, the answers will
//BE THE FIRST ON THIS PAIR MAP
    private val answers = mapOf(
        Pair(
            1, listOf(
                "larger, smaller, farther",
                "larger, smaller, closer",
                "smaller, larger, closer",
                "none of the above"
            )
        ),
        Pair(
            2, listOf(
                "C1 - Q2C",
                "C2 - Q2",
                "C3 - Q2",
                "C4 - Q2"
            )
        ),
        Pair(
            3, listOf(
                "C1 - Q3",
                "C2 - Q3",
                "C3 - Q3",
                "C4 - Q3C"
            )
        ),
        Pair(
            4, listOf(
                "C1 - Q4",
                "C2 - Q4",
                "C3 - Q4C",
                "C4 - Q4"
            )
        ),
        Pair(
            5, listOf(
                "C1 - Q5C",
                "C2 - Q5",
                "C3 - Q5",
                "C4 - Q5"
            )
        )
    )

    //THE INDEX OF THE CORRECT ANSWER IN A SPECIFIC SET OF ANSWERS EXAMPLE: IF ITS QUESTION 1
//THE ANSWERS WILL BE THE PAIR(1,LISTHERE)
    private val correctAnswer = mapOf(
        Pair(1, 1),
        Pair(2, 0),
        Pair(3, 3),
        Pair(5, 1)
    )

    private fun getRandomNumber(): Int {
        return Random.nextInt(1, questions.size + 1)
    }

    fun getQuestions() {
        val index = getRandomNumber()

        quizHelperInterface.getQuestion(
            questions[index].toString(), answers[index]!!,
            correctAnswer[index]!!.toInt()
        )
    }
}