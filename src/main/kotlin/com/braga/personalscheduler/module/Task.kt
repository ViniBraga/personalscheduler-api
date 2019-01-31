package com.braga.personalscheduler.module

import org.hibernate.annotations.GeneratorType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
data class Task (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @NotEmpty
        @Size(max = 80)
        val description: String

)