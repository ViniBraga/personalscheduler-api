package com.braga.personalscheduler.controller

import com.braga.personalscheduler.model.Task
import com.braga.personalscheduler.repository.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.management.loading.ClassLoaderRepository
import javax.validation.Valid

@CrossOrigin
@RestController
@RequestMapping("/tasks")
class TaskController {

    @Autowired
    lateinit var taskRepository: TaskRepository

    @GetMapping()
    fun listTasks() = taskRepository.findAll()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun add(@Valid @RequestBody task: Task) :Task {
        var existingTask: Optional<Task> = taskRepository.findById(task.id)
        if (existingTask.isPresent) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Already exists")
        }
        return taskRepository.save(task)
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun update(@Valid @RequestBody task: Task) : Task {
        var existingTask: Optional<Task> = taskRepository.findById(task.id)
        if (existingTask.isPresent) {
            return taskRepository.save(task)
        }
        throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: Long) {
        var existingTask: Optional<Task> = taskRepository.findById(id)
        if (existingTask.isPresent) {
            this.taskRepository.deleteById(id)
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }

}