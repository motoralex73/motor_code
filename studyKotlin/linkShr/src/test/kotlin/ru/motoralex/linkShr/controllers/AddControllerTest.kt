package ru.motoralex.linkShr.controllers

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import ru.motoralex.linkShr.LinkShrApplication
import ru.motoralex.linkShr.service.KeyMapperService
import ru.motoralex.linkShr.whenever


@AutoConfigureMockMvc
@TestPropertySource(locations = arrayOf("classpath:repositories-test.properties"))
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(LinkShrApplication::class))
@WebAppConfiguration
class AddControllerTest {

    private val LINK: String = "link"
    private val KEY: String = "key"

    @Autowired
    lateinit var webApplicationContext: WebApplicationContext

    lateinit var mockMvc: MockMvc

    @Mock
    lateinit var service: KeyMapperService

    @Autowired
    @InjectMocks
    lateinit var controller: AddController

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        mockMvc = MockMvcBuilders
            .webAppContextSetup(webApplicationContext)
            .build()
        whenever(service.add(LINK)).thenReturn(KEY)
    }

    @Test
    fun whenUserAddLinkHeTakesAKey() {
        mockMvc.perform(MockMvcRequestBuilders.post("/add")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jacksonObjectMapper().writeValueAsString(AddController.AddRequest(LINK))))
            .andExpect(MockMvcResultMatchers.jsonPath("$.key", Matchers.equalTo(KEY)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.link", Matchers.equalTo(LINK)))
    }

    @Test fun whenUserAddLinkByFormHeTakesAWebPage() {
        mockMvc.perform(MockMvcRequestBuilders.post("/addhtml")
            .param("link", LINK)
            .contentType(MediaType.APPLICATION_FORM_URLENCODED))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(KEY)))
            .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(LINK)))
    }

}