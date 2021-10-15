package com.example.viewpagerpoc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class HomeViewModel : ViewModel() {

    private val _ads = MutableLiveData<ArrayList<AdModel>>()
    val ads: LiveData<ArrayList<AdModel>> get() = _ads

    private val _hasData = _ads.map { it.isNotEmpty() }
    val hasData: LiveData<Boolean> get() = _hasData

    init {
        getData()
    }

    private fun getData() {
        _ads.value = arrayListOf(AdModel(0, "One"), AdModel(1, "Two"), AdModel(2, "Three"))
    }

    fun onAdDeleteClicked(position: Int) {
        _ads.value?.removeAt(position)
        _ads.notifyObserver()
    }

    private fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }
}