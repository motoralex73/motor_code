package ru.motoralex.controller

//import io.swagger.annotations.Api
//import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.motoralex.dto.CountryDto
import ru.motoralex.service.CountryService


@RestController
@RequestMapping("/countries")
//@Api(description = "Контроллер для демонстрации работы Swagger")
class CountryController(
    private val countryService: CountryService
) {

    @GetMapping
//    @ApiOperation("Получение списка записей о странах")
    fun getAll(@RequestParam("page") pageIndex: Int): List<CountryDto> =
        countryService.getAll(pageIndex)

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Int): CountryDto =
        countryService.getById(id)

    @GetMapping("/search")
    fun searchCountries(@RequestParam("prefix") prefix: String): List<CountryDto> =
        countryService.search(prefix)

    @GetMapping("/names")
    fun getCountryNames(): List<String> = countryService.getCountryNames()

    @PostMapping
//    @ApiOperation("Создание новой записи")
    fun create(@RequestBody dto: CountryDto): Int = countryService.create(dto)

    @PutMapping("/{id}")
//    @ApiOperation("Обновление существующей записи")
    fun update(@PathVariable id: Int, @RequestBody dto: CountryDto) {
        countryService.update(id, dto)
    }

    @DeleteMapping("/{id}")
//    @ApiOperation("Удаление записи")
    fun delete(@PathVariable id: Int) {
        countryService.delete(id)
    }
}