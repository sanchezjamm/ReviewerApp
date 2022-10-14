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
        Pair(2, "In class B operation, the current drawn from a single power supply has the form of rectified signal."),
        Pair(3, "What is basically a two-terminal parallel-inverse combination of semiconductor layers that permits triggering in either direction?\n"),
        Pair(4, "How many terminals does a diode have?"),
        Pair(5, "What is the resistor value of an ideal diode in the region of conduction?"),
        Pair(6, "What is the state of an ideal diode in the region of nonconduction?"),
        Pair(7, "The PUT (programmable unijunction transistor) is actually a type of:\n"),
        Pair(8, "The diode _______.\n"),
        Pair(9, "Calculate static resistance RD of a diode having ID = 30 mA and VD = 0.75 V.\n"),
        Pair(10, "What does a high resistance reading in both forward- and reverse-bias directions indicate?\n")
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
                "A full-wave",
                "A half-wave",
                "Both a full-wave\nand a half-wave",
                "None of the above"
            )
        ),
        Pair(
            3, listOf(
                "TRIAC",
                "QUADRAC",
                "DIAC",
                "Shockley Diode"
            )
        ),
        Pair(
            4, listOf(
                "1",
                "2",
                "3",
                "4"
            )
        ),
        Pair(
            5, listOf(
                "0",
                "5k",
                "Undefined",
                "Infinity"
            )
        ),
        Pair(
            6, listOf(
                "A short circuit",
                "An open circuit",
                "Unpredictable",
                "Undefined"
            )
        ),
        Pair(
            7, listOf(
                "UJT thyristor",
                "FET device",
                "TRIAC",
                "SCR"
            )
        ),
        Pair(
            8, listOf(
                "is the simplest of\nsemiconductor devices",
                "has characteristics\nthat closely match those\nof a simple switch",
                "is a two-terminal\ndevice",
                "All of the above"
            )
        ),
        Pair(
            9, listOf(
                "25",
                "40",
                "0.04",
                "0.025"
            )
        ),
        Pair(
            10, listOf(
                "A good diode",
                "A shorted diode",
                "An open diode",
                "A defective ohmmeter"
            )
        )
    )

    //THE INDEX OF THE CORRECT ANSWER IN A SPECIFIC SET OF ANSWERS EXAMPLE: IF ITS QUESTION 1
//THE ANSWERS WILL BE THE PAIR(1,LISTHERE)
    private val correctAnswer = mapOf(
        Pair(1, 1),
        Pair(2, 0),
        Pair(3, 2),
        Pair(4, 1),
        Pair(5, 0),
        Pair(6, 1),
        Pair(7, 0),
        Pair(8, 3),
        Pair(9, 0),
        Pair(10, 2)
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