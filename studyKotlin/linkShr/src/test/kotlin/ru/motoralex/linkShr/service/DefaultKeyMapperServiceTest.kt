package ru.motoralex.linkShr.service

import org.junit.Test
import org.junit.Assert.*

class DefaultKeyMapperServiceTest {

    private val LINK_NEW: String = "http://wow.ru"
    private val LINK: String = "http://www.eveonline.com"
    private val KEY: String = "aAbBcCdD"
    val service : KeyMapperService = DefaultKeyMapperService()

    @Test
    fun clientCanAddNewKeyWithLink() {
        assertEquals(KeyMapperService.Add.Success(KEY, LINK), service.add(KEY, LINK))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCanNotAddExistingKey() {
        service.add(KEY, LINK)
        assertEquals(KeyMapperService.Add.AlreadyExist(KEY), service.add(KEY, LINK_NEW))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCanNotTakeLinkIfKeyIsNotFoundInService() {
        assertEquals(KeyMapperService.Get.NotFound(KEY), service.getLink(KEY))
    }

}