package com.harmyFounder.harmyWorld.services;

import com.harmyFounder.harmyWorld.models.Task;
import com.harmyFounder.harmyWorld.models.enums.TaskStatus;
import com.harmyFounder.harmyWorld.repositories.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    Map<Integer, TaskStatus> statuses = new HashMap<>();

    {
        statuses.put(0, TaskStatus.NO_STATUS);
        statuses.put(1, TaskStatus.NEXT_UP);
        statuses.put(2, TaskStatus.IN_PROGRESS);
        statuses.put(3, TaskStatus.COMPLETED);
    }

    Map<Integer, List<Task>> allTasks = new HashMap<>();

    {
        allTasks.put(0, taskRepository.findByTaskStatus(statuses.get(0)));
        allTasks.put(1, taskRepository.findByTaskStatus(statuses.get(1)));
        allTasks.put(2, taskRepository.findByTaskStatus(statuses.get(2)));
        allTasks.put(3, taskRepository.findByTaskStatus(statuses.get(3)));
    }

    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    public Map<Integer, List<Task>> getAllTasksWithStatuses(){
        return allTasks;
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
