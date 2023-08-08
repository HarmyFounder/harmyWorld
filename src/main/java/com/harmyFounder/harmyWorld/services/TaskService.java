package com.harmyFounder.harmyWorld.services;

import com.harmyFounder.harmyWorld.models.Task;
import com.harmyFounder.harmyWorld.repositories.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    public List<Task> getByTag(String filter){
        return taskRepository.findByTag(filter);
    }

    public Task create(Task task){
        return taskRepository.save(task);
    }

    public Task update(Task taskToBeUpdated, Task updatedTask){
        BeanUtils.copyProperties(updatedTask, taskToBeUpdated, "id");
        return taskRepository.save(taskToBeUpdated);
    }

    public void delete(Task task){
        taskRepository.delete(task);
    }



}
