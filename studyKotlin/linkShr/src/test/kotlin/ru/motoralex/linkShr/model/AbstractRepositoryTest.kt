package ru.motoralex.linkShr.model

import com.github.springtestdbunit.DbUnitTestExecutionListener
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests

import org.springframework.*
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import ru.motoralex.linkShr.LinkShrApplication

@TestPropertySource(locations = arrayOf("classpath:repository-test.properties"))
@TestExecutionListeners(DbUnitTestExecutionListener::class)
@SpringBootTest(classes = arrayOf(LinkShrApplication::class))
@DirtiesContext
abstract class AbstractRepositoryTest: AbstractTransactionalJUnit4SpringContextTests() {

}