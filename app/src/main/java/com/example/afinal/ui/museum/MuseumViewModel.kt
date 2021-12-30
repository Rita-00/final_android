package com.example.afinal.ui.museum

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afinal.R

class MuseumViewModel : ViewModel() {

    var itemsList: List<Triple<Int, String, String>> = listOf(
        Triple(R.drawable.build1, "Эрмитаж", "Санкт-Петербург, Россия"),
        Triple(R.drawable.build2, "Лувр", "Париж, Франция"),
        Triple(R.drawable.build3, "Третьяковская галерея", "Москва, Росия"),
        Triple(R.drawable.build4, "Креллер-Мюллер", "Оттерло, Нидерланды"),
               )
    fun getList(): List<Triple<Int, String, String>> {
        return itemsList
    }
}