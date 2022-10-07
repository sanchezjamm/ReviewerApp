package com.example.reviewerappproject

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.reviewerappproject.databinding.ActivityDisplayReviewerBinding

class DisplayReviewerApp : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityDisplayReviewerBinding
    private lateinit var sharedPreferences: SharedPreferences

    private var categoryNumber = -1
    private var quoteString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayReviewerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)

        // Retrieve Data from Intent
        categoryNumber = intent.getIntExtra(CATEGORY,1)
        quoteString = MainHelper.getReviewerApp(categoryNumber)
        binding.txtDisplayReviewer.text = quoteString

        // Button Binding
        binding.btnShuffle.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            (R.id.btn_Shuffle) -> {
                //Randomize it
                quoteString = MainHelper.getReviewerApp(categoryNumber)
                binding.txtDisplayReviewer.text = quoteString
            }

        }
    }
}

