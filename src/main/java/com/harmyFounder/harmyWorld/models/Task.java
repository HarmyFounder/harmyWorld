package com.harmyFounder.harmyWorld.models;

import com.harmyFounder.harmyWorld.models.enums.TaskStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private String tag;
    private TaskStatus taskStatus;
    private int taskStatusIndex;

    public Task() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getTaskStatusIndex() {
        return taskStatusIndex;
    }

    public void setTaskStatusIndex(int taskStatusIndex) {
        this.taskStatusIndex = taskStatusIndex;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
