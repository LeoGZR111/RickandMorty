package com.example.rickmorty.repository

import RickAndMortyApi
import com.example.rickmorty.models.Info
import com.example.rickmorty.models.Result

class CharacterRepository(private val api: RickAndMortyApi) {
    suspend fun getCharacters(): List<Result> {
        val response = api.getCharacters()
        return response.results
    }

    suspend fun getCharacterById(characterId: Int): Result {
        return api.getCharacterById(characterId)
    }
}
