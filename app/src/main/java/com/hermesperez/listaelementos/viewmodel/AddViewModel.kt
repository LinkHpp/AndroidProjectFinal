package com.hermesperez.listaelementos.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hermesperez.listaelementos.datastore.AppPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel(application: Application) : AndroidViewModel(application) {
    private val preferences = AppPreferences(application.applicationContext)

    private val _fullname = MutableLiveData<String>()
    val fullname: LiveData<String> = _fullname

    fun onFullnameChange(fullname: String){
        _fullname.value = fullname
    }

    fun saveUser(fullname: String){
        viewModelScope.launch(Dispatchers.IO){
            preferences.saveFullName(fullname)
            _fullname.postValue(fullname)
        }
    }

    fun loadUser(){
        viewModelScope.launch ( Dispatchers.IO ){
            preferences.loadName().collect{
                _fullname.postValue(it)
            }
        }
    }
}