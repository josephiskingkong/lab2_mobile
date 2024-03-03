package com.example.lab2

import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApiService {
    @GET("character")
    fun getAllCharacters(): Call<CharacterResponse>
}

data class CharacterResponse(
    val results: List<Character>
)