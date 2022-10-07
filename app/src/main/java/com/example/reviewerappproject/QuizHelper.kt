package com.example.reviewerappproject

import android.content.Context
import kotlin.random.Random

class QuizHelper(context: Context) {

    private var quizHelperInterface: QuestionsInterface
    private val answerLimit = 4

    interface QuestionsInterface{
        fun getQuestion(question: String, answerIndex: Int, answers: List<Pair<Int,String>>)
    }

    init {
        quizHelperInterface = context as QuestionsInterface
    }

    private val questions = mapOf(
        Pair(1,"Question 1"),
        Pair(2,"Question 2"),
        Pair(3,"Question 3"),
        Pair(4,"Question 4"),
        Pair(5,"Question 5"),
        Pair(6,"Question 6"),
        Pair(7,"Question 6"),
        Pair(8,"Question 6"),
        Pair(9,"Question 6"),
        Pair(10,"Question 6")

    )
    private val answers = mapOf(
        Pair(1,"Answer to Q1"),
        Pair(2,"Answer to Q2"),
        Pair(3,"Answer to Q3"),
        Pair(4,"Answer to Q4"),
        Pair(5,"Answer to Q5"),
        Pair(6,"Answer to Q6"),
        Pair(7,"Answer to Q6"),
        Pair(8,"Answer to Q6"),
        Pair(9,"Answer to Q6"),
        Pair(10,"Answer to Q6")
    )

    private fun getRandomNumber(): Int{
        return Random.nextInt(1, questions.size + 1)
    }

    fun getQuestions(){
        val index = getRandomNumber()
        val qAnswers : MutableList<Pair<Int,String>> = mutableListOf()
        var qLoaded = false;
        qAnswers.add(Pair(index,answers[index].toString()))
        do{
            val qNumber = getRandomNumber()
            if(qNumber != index){
                qAnswers.add(Pair(qNumber,answers[qNumber].toString()))
            }
            if(answerLimit == qAnswers.size){
                qLoaded = true
            }
        }while (!qLoaded)

        quizHelperInterface.getQuestion(questions[index].toString(), index, qAnswers.shuffled())
    }
}
