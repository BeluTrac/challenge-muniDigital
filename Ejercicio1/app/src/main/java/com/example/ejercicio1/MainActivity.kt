package com.example.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.ejercicio1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.wordSaved.observe(this, {
            saveWorldValue ->
            binding.saveWordText.text = getString(R.string.the_text_saved_is,saveWorldValue)
        })

        setContentView(binding.root)

        binding.launchButton.setOnClickListener {
            openActivity()
        }

        binding.saveWordText.text = ""

        binding.saveButton.setOnClickListener {
           viewModel.setWord(binding.editText.text.toString())
        }
    }

    private fun openActivity() {
        val intent = Intent(this,MainActivity2::class.java)
        intent.putExtra(MainActivity2.TEXT_KEY,viewModel.wordSaved.value)
        startActivity(intent)
    }

    override fun onPause() {
        super.onPause()
        binding.editText.setText("")
    }


}