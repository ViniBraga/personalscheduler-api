package com.braga.personalscheduler.repository

import com.braga.personalscheduler.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TaskRepository : JpaRepository<Task, Long> {

    fun findMaxPosition(): Optional<Task>

}