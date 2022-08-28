package com.motoralex73.springrestrepo.dao

import com.motoralex73.springrestrepo.model.Band
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "bands")
interface BandRepo: CrudRepository<Band, Int>