package com.hitch.fetchrewardsinterview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel(app: Application): AndroidViewModel(app), CoroutineScope by MainScope() {
    val baseUrl = "https://fetch-hiring.s3.amazonaws.com"

    private val _onItemsUpdated: MutableLiveData<Boolean> = MutableLiveData()
    val onItemsUpdated: LiveData<Boolean> = _onItemsUpdated

    var items: List<Item> = listOf(
                Item("", 0, 0),
                Item("", 0, 0),
                Item("", 0, 0),
                Item("", 0, 0),
                Item("", 0, 0),
                Item("", 0, 0),
                Item("", 0, 0),
                Item("", 0, 0),
                Item("", 0, 0),
                Item("", 0, 0),
                Item("", 0, 0),
                Item("", 0, 0))

    fun printData() {
        items.forEach {
            println("id: ${it.id} listId: ${it.listId} name: ${it.name}")
        }
    }

    fun getdata() {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(APIService::class.java)

        launch(Dispatchers.IO) {
            val response = service.getHiringData()
            items = response.filter { !it.name.isNullOrBlank() }.sortedBy { it.id }.sortedBy { it.listId }
            _onItemsUpdated.postValue(true)
        }
    }
}