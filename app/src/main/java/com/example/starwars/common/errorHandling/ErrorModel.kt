package com.example.starwars.common.errorHandling

data class ErrorModel(
    val exception: Exception?,
    val code: String
)