package com.example.activityviewmo.ui.fragments.firstfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.activityviewmo.data.model.Model

class FirstViewModel : ViewModel() {

    private val _liveData = MutableLiveData<List<Model>>()
    val liveData: LiveData<List<Model>> = _liveData

    private val noteList = mutableListOf<Model>()

    fun addNote(number: String, title: String, description: String) {

        noteList.add(Model(
            name = number,
            age = title,
            email = description
        ))
        _liveData.value = noteList.toList()
    }
}