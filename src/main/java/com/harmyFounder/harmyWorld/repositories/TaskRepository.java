package com.harmyFounder.harmyWorld.repositories;

import com.harmyFounder.harmyWorld.models.Task;
import com.harmyFounder.harmyWorld.models.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTaskStatus(TaskStatus taskStatus);

    List<Task> findByTag(String tag);

}
