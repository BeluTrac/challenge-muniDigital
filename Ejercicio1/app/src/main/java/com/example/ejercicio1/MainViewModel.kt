package com.example.ejercicio1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _wordSaved : MutableLiveData<String> = MutableLiveData()
    val wordSaved: LiveData<String>
        get() = _wordSaved


    fun setWord(word :String)
    {
        if(!word.isEmpty())
        {
            _wordSaved.value = word
        }

    }


}