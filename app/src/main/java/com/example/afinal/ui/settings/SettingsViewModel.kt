package com.example.afinal.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {
    private val _head = MutableLiveData<String>().apply {
        value = "О приложении:"
    }
    val head: LiveData<String> = _head

    private val _about = MutableLiveData<String>().apply {
        value = "Данное приложение создано для увелечение знаний в области изобразительного исскуства"
    }
    val about: LiveData<String> = _about

    private val _text = MutableLiveData<String>().apply {
        value = "Исходный код приложения: "
    }
    val text: LiveData<String> = _text

    private val _name = MutableLiveData<String>().apply {
        value = "Rita-00  "
    }
    val name: LiveData<String> = _name

    private val _link = MutableLiveData<String>().apply {
        value = "Ccылка: https://github.com/Rita-00/final_android"
    }
    val link: LiveData<String> = _link
}