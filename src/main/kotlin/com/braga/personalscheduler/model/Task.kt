package com.braga.personalscheduler.model

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
data class Task (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @NotEmpty
        @Size(max = 80)
        var description: String? = null,

        @Column(name = "LAST_UPDATE")
        var lastUpdate: LocalDateTime? = LocalDateTime.now(),

        @Column(name = "CREATED_AT")
        var createdAt: LocalDateTime?  = LocalDateTime.now(),

        @Column(name = "IS_DONE")
        var isDone: Boolean? = false,

        var position: Long? = null

)