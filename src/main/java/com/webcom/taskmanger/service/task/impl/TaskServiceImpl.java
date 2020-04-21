package com.webcom.taskmanger.service.task.impl;

import com.webcom.taskmanger.dto.task.TaskSaveDto;
import com.webcom.taskmanger.dto.task.TaskUpdateDto;
import com.webcom.taskmanger.entity.Task;
import com.webcom.taskmanger.repository.TaskRepository;
import com.webcom.taskmanger.service.task.TaskService;
import com.webcom.taskmanger.service.task.transformer.TaskTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskTransformer taskTransformer;

    @Override
    public void saveTask(TaskSaveDto taskSaveDto) {
        Task task = taskTransformer.saveDtoToEntity(taskSaveDto);
        task.getTaskSet().setLastChangeDate(LocalDateTime.now());
        taskRepository.save(task);
    }

    @Override
    public void updateTask(TaskUpdateDto taskUpdateDto) {
        taskRepository.save(taskTransformer.updateDtoToEntity(taskUpdateDto));
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
