package ru.motoralex.linkShr.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "links")
data class Link(
    var text: String = "",
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "links_sequence")
    @SequenceGenerator(name = "links_sequence", sequenceName = "links_seq")
    var id: Long = 0
)