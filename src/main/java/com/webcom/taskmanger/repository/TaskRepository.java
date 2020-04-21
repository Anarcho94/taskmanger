package com.webcom.taskmanger.repository;

import com.webcom.taskmanger.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByTaskSetName(String name);
}
