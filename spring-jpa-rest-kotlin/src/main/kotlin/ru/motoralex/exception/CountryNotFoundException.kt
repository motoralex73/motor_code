package ru.motoralex.exception

import org.springframework.http.HttpStatus

class CountryNotFoundException(countryId: Int) : BaseException(
    HttpStatus.NOT_FOUND,
    ApiError(
        errorCode = "country.not.found",
        description = "Страна с id=$countryId не найдена"
    )
)
