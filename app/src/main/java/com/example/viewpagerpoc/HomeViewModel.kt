package com.example.viewpagerpoc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _ads = MutableLiveData<ArrayList<AdModel>>()
    val ads: LiveData<ArrayList<AdModel>> get() = _ads

    init {
        getData()
    }

    private fun getData() {
        _ads.value = arrayListOf(AdModel(0, "One"), AdModel(1, "Two"), AdModel(2, "Three"))
    }

    fun onAdDeleteClicked(position: Int) {
        _ads.value?.removeAt(position)
    }
}