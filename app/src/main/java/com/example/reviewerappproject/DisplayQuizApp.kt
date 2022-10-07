package com.example.reviewerappproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.reviewerappproject.databinding.ActivityDisplayquizBinding

class DisplayQuizApp : AppCompatActivity(),QuizHelper.QuestionsInterface{
    private lateinit var quizHelper: QuizHelper
    private lateinit var binding: ActivityDisplayquizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayquizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quizHelper = QuizHelper(this)
        binding.btnQuiz.setOnClickListener {
            quizHelper.getQuestions()
        }

    }

    override fun getQuestion(question: String, answersList: List<String>, correctAnswerIndex: Int) {
        Log.d(DisplayQuizApp::class.simpleName,question)
        Log.d(DisplayQuizApp::class.simpleName,answersList.toString())
        Log.d(DisplayQuizApp::class.simpleName,correctAnswerIndex.toString())
    }
}