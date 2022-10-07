package com.example.reviewerappproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.reviewerappproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, QuizHelper.QuestionsInterface {

    private lateinit var binding : ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var quizHelper: QuizHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        sharedPreferences = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        setContentView(binding.root)
        supportActionBar?.hide()

        // BUTTON BINDING
        binding.btnDefTerms.setOnClickListener(this)
        binding.btnFormula.setOnClickListener(this)
        binding.btnQuiz.setOnClickListener(this)

        quizHelper = QuizHelper(this)
        binding.btnQuiz.setOnClickListener {
            quizHelper.getQuestions()
        }

    }

    override fun getQuestion(question: String, answerIndex: Int, answers: List<Pair<Int,String>>) {
        Log.d(MainActivity::class.simpleName,question)
        Log.d(MainActivity::class.simpleName,answerIndex.toString())
        Log.d(MainActivity::class.simpleName,answers.toString())
    }

    override fun onClick(p0: View?) {
        when (p0!!.id){
            (R.id.btn_DefTerms) -> {
                val intent = Intent(this, DisplayReviewerApp::class.java)
                intent.putExtra(CATEGORY,1)
                startActivity(intent)
            }

            (R.id.btn_Formula) -> {
                val intent = Intent(this, DisplayReviewerApp::class.java)
                intent.putExtra(CATEGORY,2)
                startActivity(intent)
            }

            (R.id.btn_Quiz) -> {
                val intent = Intent(this, DisplayReviewerApp::class.java)
                intent.putExtra(CATEGORY,3)
                startActivity(intent)
            }

        }
    }
}
