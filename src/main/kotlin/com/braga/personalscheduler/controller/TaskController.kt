package com.braga.personalscheduler.controller

import com.braga.personalscheduler.model.Task
import com.braga.personalscheduler.repository.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors
import javax.validation.Valid

@CrossOrigin
@RestController
@RequestMapping("/tasks")
class TaskController {

    @Autowired
    lateinit var taskRepository: TaskRepository

    @GetMapping()
    fun listTasks() = taskRepository.findAllByOrderByPosition()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addTask(@Valid @RequestBody task: Task) :Task {
        task.id = null
        return taskRepository.save(task)
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateTask(@Valid @RequestBody task: Task) : Task {
        val existingTask: Optional<Task> = taskRepository.findById(task.id!!)
        if (existingTask.isPresent) {
            task.createdAt = existingTask.get().createdAt
            return taskRepository.save(task)
        }
        throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @PutMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    fun updateTasks(@Valid @RequestBody tasks: List<Task>) {
        tasks.forEach {task: Task ->
            val existingTask: Optional<Task> = taskRepository.findById(task.id!!)
            if (existingTask.isPresent) {
                task.createdAt = existingTask.get().createdAt
                taskRepository.save(task)
            } else {
                task.id = null;
                taskRepository.save(task)
            }
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteTask(@PathVariable id: Long) {
        val existingTask: Optional<Task> = taskRepository.findById(id)
        if (existingTask.isPresent) {
            this.taskRepository.deleteById(id)
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }

}