package com.hermesperez.listaelementos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hermesperez.listaelementos.model.Videogame
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class VideogameViewModel: ViewModel() {
    private val _videogames = MutableLiveData<List<Videogame>>()
    val videogames: LiveData<List<Videogame>> = _videogames

    private val _selectedVideogame = MutableLiveData<Videogame>()
    val selectedVideogame: LiveData<Videogame> = _selectedVideogame

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            _videogames.value = Videogame.getData()
            _isLoading.value = false
        }
    }

    fun deleteVideogame(videogame: Videogame){
        _videogames.value = _videogames.value?.filter { it != videogame }
    }

    fun onBookClicked(videogame: Videogame){
        _selectedVideogame.value = videogame
    }

    fun makeFavourite(videogame: Videogame) {
        val updatedList = mutableListOf<Videogame>()
        _videogames.value?.forEach{
            val auxVideogame = it.copy()
            if(auxVideogame == videogame){
                auxVideogame.favourite = !auxVideogame.favourite
                _selectedVideogame.value = auxVideogame
            }

            updatedList.add(auxVideogame)
        }
        _videogames.value = updatedList

    }
}