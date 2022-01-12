package com.example.ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    companion object{
        const val TEXT_KEY = "text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = intent.extras?.getString(TEXT_KEY)


            if(text.isNullOrEmpty())
            {
                binding.wordText.text = getString(R.string.there_is_no_text_loaded_in_the_previous_view)
            }else
            {
                binding.wordText.text =  getString(R.string.The_text_loaded_in_the_previous_view_was,text)
            }



    }
}