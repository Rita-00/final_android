package com.example.afinal.ui.masters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afinal.R

class MastersViewModel : ViewModel() {


    var itemsList: List<Triple<Int, String, String>> = listOf(
        Triple(R.drawable.people1, "Шишкин Иван Иванович", "1832-1898"),
        Triple(R.drawable.people2, "Левитан Исаак Ильич", "1860-1900"),
        Triple(R.drawable.people3, "Айвазовский Алексей Константинович", "1817-1900"),
        Triple(R.drawable.people4, "Саврасов Алексей Кондратьевич", "1830-1897"),
        Triple(R.drawable.people5, "Репин Илья Ефимович", "1844-1930"),
        Triple(R.drawable.people6, "Куинджи Архип Иванович", "1842-1910"),
        Triple(R.drawable.people7, "Васнецов Виктор Михайлович", "1848-1926"),
        Triple(R.drawable.people8, "Врубель Михаил Александрович", "1856-1910"),

        )
    fun getList(): List<Triple<Int, String, String>> {
        return itemsList
    }
   /* private val _list = MutableLiveData<String>().apply {
        value = "This is masters Fragment"
    }
    val text: LiveData<String> = list
}*/
    private val _text = MutableLiveData<String>().apply {
        value = "This is masters Fragment"
    }
    val text: LiveData<String> = _text
}