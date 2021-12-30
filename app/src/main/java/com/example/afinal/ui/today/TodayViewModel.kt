package com.example.afinal.ui.today


import android.annotation.SuppressLint
import android.content.res.Resources
import android.provider.Settings.Secure.getString
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afinal.R
import androidx.annotation.StringRes
import java.util.*


class TodayViewModel : ViewModel() {

    private val random = Random()
   // private val position = 1
    //val res: Resources = Resources.getSystem()
    //private val tit = arrayListOf<String>(*res.getStringArray(R.array.title))


    private val titles = arrayListOf<String>("Поцелуй", "Море", "Корабельная роща", "Дама в голубом", "Цветущие ветки миндаля")
    private val authors = arrayListOf<String>("Густав Климт", "Айвазовский", "Шишкин", "Гейнсбор", "Ван Гог")
    private val year = arrayListOf<String>("1908-1909", "1864", "1898", "1780", "1890")
    private val history = arrayListOf<String>(
        "«Поцелуй», первоначальное название «Влюблённые», — картина австрийского художника Густава Климта. Написана в 1908—1909 годах, считается ключевым произведением «золотого периода» творчества художника.",
        "Море — картина Ивана Айвазовского, написанная им в 1864 году. Наибольшее количество пейзажей в богатейшем творческом наследии художника связано с изображением Чёрного моря и крымской природы.",
        "Картина корабельная роща это заключительный этап в творчестве великолепного художника, мастера лесных пейзажей Ивана Шишкина. Этот живописный шедевр написан с потрясающим лесным колоритом, утреннее время, гордые сосны великаны с заплесневелыми стволами, освещенные солнцем прогибаются от веса своих ветвей.",
        "«Дама в голубом» — портрет работы английского живописца Томаса Гейнсборо. Написан в конце 1770-х — начале 1780-х, в период наивысшего расцвета художественного мастерства Гейнсборо. Находится в Государственном Эрмитаже в Санкт-Петербурге.",
        "«Цветущие ветки миндаля» — картина нидерландского живописца Винсента ван Гога, написанная им в Сен-Реми-де-Прованс в 1890 году. 31 января 1890 года Тео ван Гог написал Винсенту о рождении сына, которого назвали Винсент Виллем в честь дяди.")


    val day = random.nextInt(4)

    private fun randomTitle() : String {
        return titles[day]
    }
    private fun randomAuthor() : String {
        return authors[day]
    }
    private fun randomYear() : String {
        return year[day]
    }

    private fun randomHistory() : String {
        return history[day]
    }

    private fun randomPicture() : Int{

        return when(day) {
            0 -> R.drawable.image1
            1 -> R.drawable.image2
            2 -> R.drawable.image3
            3 -> R.drawable.image4
            else -> R.drawable.image5
        }
    }

    private val _image = MutableLiveData<Int>().apply {
        value = randomPicture()
    }
    val image: LiveData<Int> = _image

    private val _name = MutableLiveData<String>().apply {
        value = randomTitle()
    }
    val name: LiveData<String> = _name


    private val _artist = MutableLiveData<String>().apply {
        value = randomAuthor()
    }
    val artist: LiveData<String> = _artist

    private val _years = MutableLiveData<String>().apply {
        value = randomYear()
    }
    val years: LiveData<String> = _years

    private val _histor = MutableLiveData<String>().apply {
        value = randomHistory()
    }
    val histor: LiveData<String> = _histor

}