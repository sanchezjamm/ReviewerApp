package com.example.reviewerappproject

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.reviewerappproject.databinding.ActivityDisplaydeftermsBinding

class DisplayReviewerApp : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityDisplaydeftermsBinding
    private var categoryNumber = -1
    private var termString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplaydeftermsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        // Retrieve Data from Intent
        categoryNumber = intent.getIntExtra(CATEGORY,1)
        termString = MainHelper.getReviewerApp(categoryNumber)
        binding.txtDisplayDefinition.text = termString

        // Button Binding
        binding.btnShuffledt.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            (R.id.btn_shuffledt) -> {
                //Randomize it
                termString = MainHelper.getReviewerApp(categoryNumber)
                binding.txtDisplayDefinition.text = termString
            }

        }
    }
}

