package com.braga.personalscheduler.model

import org.hibernate.annotations.GeneratorType
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
data class Task (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @NotEmpty
        @Size(max = 80)
        val description: String,

        @Column(name = "LAST_UPDATE")
        val lastUpdate: LocalDateTime = LocalDateTime.now(),

        @Column(name = "CREATED_AT")
        val createdAt: LocalDateTime = LocalDateTime.now(),

        @Column(name = "IS_DONE")
        val isDone: Boolean = false

)