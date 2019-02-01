package com.braga.personalscheduler.repository

import com.braga.personalscheduler.model.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task, Long>