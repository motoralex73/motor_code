package ru.motoralex.linkShr.controllers

import org.assertj.core.api.InstanceOfAssertFactories.PATH
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.assertj.AssertableReactiveWebApplicationContext
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MockMvcBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import ru.motoralex.linkShr.LinkShrApplication

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(LinkShrApplication::class))
@WebAppConfiguration
class RedirectControllerTest {

    @Autowired lateinit var webApplicationContext: WebApplicationContext
    lateinit var mocMvc: MockMvc

    @Before
    fun init() {
        mocMvc = MockMvcBuilders
            .webAppContextSetup(webApplicationContext)
            .build()
    }

    private val PATH = "/aAbBcCdD"
    private val REDIRECT_STATUS : Int = 302
    private val HEADER_NAME = "Location"
    private val HEADER_VALUE = "http://www.eveonline.com"

    @Test fun controllerMustRedirectUsWhenRequestIsSuccesful() {
        mocMvc.perform(get(PATH))
            .andExpect(status().`is`(REDIRECT_STATUS))
            .andExpect(header().string(HEADER_NAME, HEADER_VALUE))
    }

    private val BAD_PATH = "/olololo"
    private val NOT_FOUND: Int = 404

    @Test fun controllerMustReturn404InBadKey() {
        mocMvc.perform(get(BAD_PATH))
            .andExpect(status().`is`(NOT_FOUND))
    }
}