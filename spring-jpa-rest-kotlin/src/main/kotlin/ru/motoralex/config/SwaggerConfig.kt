package ru.motoralex.config

//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import springfox.documentation.builders.PathSelectors
//import springfox.documentation.builders.RequestHandlerSelectors
//import springfox.documentation.spi.DocumentationType
//import springfox.documentation.spring.web.plugins.Docket
//
//@Configuration
//class SwaggerConfig {
//    @Bean
//    fun api(): Docket {
//        return Docket(DocumentationType.SWAGGER_2) //тип документации
//            .select()
//            .apis(RequestHandlerSelectors.basePackage("ru.motoralex.controller")) //нахождение контроллера
//            .paths(PathSelectors.any()) //берем все пути, все эндпоиты
//            .build()
//    }
//}