package com.example.rickmorty.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel(private val repository: CharacterRepository) : ViewModel() {
    private val _characters = MutableStateFlow<List<Result>>(emptyList())
    val characters: StateFlow<List<Result>> = _characters

    private val _selectedCharacter = MutableStateFlow<Result?>(null)
    val selectedCharacter: StateFlow<Result?> = _selectedCharacter

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            _characters.value = repository.getCharacters()
        }
    }

    fun loadCharacterById(characterId: Int) {
        viewModelScope.launch {
            _selectedCharacter.value = repository.getCharacterById(characterId)
        }
    }
}
