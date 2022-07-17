package ru.motoralex73.smlr.controllers

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import ru.motoralex73.smlr.SmlrApplication

@RunWith(SpringJUnit4ClassRunner::class) //с каким классом запускается
@SpringApplicationConfiguration(classes = [SmlrApplication::class])
@WebAppConfiguration
class RedirectControllerTest {
    private val HEADER_VALUE = "http://www.eveonline.com"
    private val HEADER_NAME = "Location"
    private val REDIRECT_STATUS = 302
    private val PATH = "/aAbBcCdD"

    @Autowired lateinit var webApplicationContext: WebApplicationContext
    lateinit var mockMvc: MockMvc

    @Before
    fun init() {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(webApplicationContext)
            .build()
    }

    @Test
    fun controllerMustRedirectUsWhenRequestIsSuccessful() {
        mockMvc.perform(get(PATH))
            .andExpect(status().`is`(REDIRECT_STATUS))
            .andExpect(header().string(HEADER_NAME,HEADER_VALUE))
    }
}

