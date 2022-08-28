package ru.motoralex.exception

data class ApiError(
    val errorCode: String, // country.not.found
    val description: String
)
