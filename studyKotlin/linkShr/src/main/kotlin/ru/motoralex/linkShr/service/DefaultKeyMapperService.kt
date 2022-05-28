package ru.motoralex.linkShr.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import ru.motoralex.linkShr.model.Link
import ru.motoralex.linkShr.model.repositories.LinkRepository

@Component
open class DefaultKeyMapperService : KeyMapperService {

    @Autowired
    lateinit var converter: KeyConverterService

    @Autowired
    lateinit var repo: LinkRepository

    @Transactional
    override fun add(link: String): String = converter.idToKey(repo.save(Link(link)).id)


    override fun getLink(key: String): KeyMapperService.Get {
       val result = repo.findOne(converter.keyToId(key))
       return if (result.isPresent) {
           KeyMapperService.Get.Link(result.get().text)
       }
        else{
            KeyMapperService.Get.NotFound(key)
        }
    }
}

