package com.harmyFounder.harmyWorld.controllers;

import com.harmyFounder.harmyWorld.models.Task;
import com.harmyFounder.harmyWorld.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.getAll();
    }

    @GetMapping("/allWithStatuses")
    public Map<Integer, List<Task>> getAllSorted() {
        return taskService.getAllTasksWithStatuses();
    }

    @GetMapping("/{id}")
    public Task getCertain(@PathVariable("id") Task task) {
        return task;
    }

    @PostMapping("/ByTag")
    public List<Task> getByTag(@RequestParam String filter) {
        return taskService.getByTag(filter);
    }

    @PostMapping("/new")
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @PutMapping("/{id}/edit")
    public Task updateTask(@PathVariable("id") Task taskToBeUpdated, Task updatedTask){
        return taskService.update(taskToBeUpdated, updatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Task task){
        taskService.delete(task);
    }

}

