package com.example.lab2

data class Character(
    val id: Int,
    val name: String,
    val species: String,
    val image: String
) {
    fun getType(): Int = when (species.lowercase()) {
        "human" -> TYPE_IMAGE
        "alien" -> TYPE_NAME
        else -> TYPE_SPECIES
    }

    companion object {
        const val TYPE_IMAGE = 0
        const val TYPE_NAME = 1
        const val TYPE_SPECIES = 2
    }
}