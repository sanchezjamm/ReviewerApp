package com.example.reviewerappproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import com.example.reviewerappproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding : ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        sharedPreferences = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        setContentView(binding.root)
        supportActionBar?.hide()

        // BUTTON BINDING
        binding.btnDefTerms.setOnClickListener(this)
        binding.btnFormulas.setOnClickListener(this)
        binding.btnTestYourself.setOnClickListener(this)

        }

    override fun onClick(p0: View?) {
        when (p0!!.id){
            (R.id.btn_DefTerms) -> {
                val intent = Intent(this, DisplayReviewerApp::class.java)
                intent.putExtra(CATEGORY,1)
                startActivity(intent)
            }

            (R.id.btn_Formulas) -> {
                val intent = Intent(this, DisplayFormula::class.java)
                intent.putExtra(CATEGORY,2)
                startActivity(intent)
            }

            (R.id.btn_TestYourself) -> {
                val intent = Intent(this, DisplayQuizApp::class.java)
                intent.putExtra(CATEGORY,3)
                startActivity(intent)
            }

        }
    }



}
