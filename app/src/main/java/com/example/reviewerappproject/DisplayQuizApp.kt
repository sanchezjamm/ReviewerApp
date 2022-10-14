package com.example.reviewerappproject

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.reviewerappproject.databinding.ActivityDisplayquizBinding

class DisplayQuizApp : AppCompatActivity(),QuizHelper.QuestionsInterface, View.OnClickListener{
    private lateinit var quizHelper: QuizHelper
    private lateinit var binding: ActivityDisplayquizBinding
    private var correctAnswer:Int = -1
    private var clickedButton:Int = -1
    private var questionsAnswered:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayquizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        quizHelper = QuizHelper(this)
        binding.btnQuiz.setOnClickListener {
            quizHelper.getQuestions()
        }


        binding.txtQuestion.isVisible = false
        binding.button1.isVisible = false
        binding.button2.isVisible = false
        binding.button3.isVisible = false
        binding.button4.isVisible = false


        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
    }

    override fun getQuestion(question: String, answersList: List<String>, correctAnswerIndex: Int) {
//        Log.d(DisplayQuizApp::class.simpleName,question)
//        Log.d(DisplayQuizApp::class.simpleName,answersList.toString())
//        Log.d(DisplayQuizApp::class.simpleName,correctAnswerIndex.toString())

        correctAnswer = correctAnswerIndex
        binding.txtQuestion.text = question
        binding.button1.text = answersList[0].toString()
        binding.button2.text = answersList[1].toString()
        binding.button3.text = answersList[2].toString()
        binding.button4.text = answersList[3].toString()

        binding.btnQuiz.isVisible = false
        binding.btnQuiz.isEnabled = false
        binding.txtResult.isVisible = false

        binding.txtQuestion.isVisible = true
        binding.button1.isVisible = true
        binding.button2.isVisible = true
        binding.button3.isVisible = true
        binding.button4.isVisible = true

        binding.button1.isEnabled = true
        binding.button2.isEnabled = true
        binding.button3.isEnabled = true
        binding.button4.isEnabled = true


        questionsAnswered++
        if (questionsAnswered==11){
            binding.txtQuestion.isVisible = false
            binding.button1.isVisible = false
            binding.button2.isVisible = false
            binding.button3.isVisible = false
            binding.button4.isVisible = false

            binding.btnQuiz.isVisible = true
            binding.btnQuiz.isEnabled = true

            binding.txtResult.isVisible = true
            binding.txtResult.text = "Quiz is finished!"

            questionsAnswered = 0
        }
    }

    override fun onClick(p0: View?) {

        when(p0!!.id){
            (R.id.button1) -> {
                clickedButton=0
                evaluateAnswer(clickedButton,correctAnswer)
            }
            (R.id.button2) -> {
                clickedButton=1
                evaluateAnswer(clickedButton,correctAnswer)
            }
            (R.id.button3) -> {
                clickedButton=2
                evaluateAnswer(clickedButton,correctAnswer)
            }
            (R.id.button4) -> {
                clickedButton=3
                evaluateAnswer(clickedButton,correctAnswer)
            }
        }
    }

    private fun evaluateAnswer(clickedButton:Int, correctAnswer:Int){
        if (clickedButton == correctAnswer) {
            Toast.makeText(this,"You are correct!", Toast.LENGTH_SHORT).show()
            quizHelper.getQuestions()
        } else {
            Toast.makeText(this,"You are wrong!", Toast.LENGTH_SHORT).show()
            when(clickedButton) {
                (0) -> {
                    binding.button1.isEnabled = false
                }
                (1) -> {
                    binding.button2.isEnabled = false
                }
                (2) -> {
                    binding.button3.isEnabled = false
                }
                (3) -> {
                    binding.button4.isEnabled = false
                }
            }

        }
    }
}