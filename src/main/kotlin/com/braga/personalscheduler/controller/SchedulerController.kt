package com.braga.personalscheduler.controller

import com.braga.personalscheduler.module.Task
import com.braga.personalscheduler.repository.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.management.loading.ClassLoaderRepository

@CrossOrigin
@RestController
@RequestMapping("/tasks")
class SchedulerController {

    @Autowired
    lateinit var taskRepository: TaskRepository

    @GetMapping()
    fun listTasks() = taskRepository.findAll()

}