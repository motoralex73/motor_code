package ru.motoralex.linkShr

import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

@TestPropertySource(locations = arrayOf("classpath:repository-test.properties"))
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(LinkShrApplication::class))
@WebAppConfiguration
class LinkShrApplicationTests {

	@Test
	fun contextLoads() {
	}

}
