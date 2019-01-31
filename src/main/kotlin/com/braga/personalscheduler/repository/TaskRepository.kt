package com.braga.personalscheduler.repository

import com.braga.personalscheduler.module.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task, Long>