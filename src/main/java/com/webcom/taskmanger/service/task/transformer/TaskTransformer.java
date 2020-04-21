package com.webcom.taskmanger.service.task.transformer;

import com.webcom.taskmanger.dto.task.TaskInfoDto;
import com.webcom.taskmanger.dto.task.TaskSaveDto;
import com.webcom.taskmanger.dto.task.TaskUpdateDto;
import com.webcom.taskmanger.entity.Task;
import com.webcom.taskmanger.entity.TaskSet;
import com.webcom.taskmanger.repository.TaskRepository;
import com.webcom.taskmanger.repository.TaskSetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class TaskTransformer {

    private final TaskRepository taskRepository;

    private final TaskSetRepository taskSetRepository;

    public Task saveDtoToEntity(TaskSaveDto dto) {
        Task task = new Task();
        task.setName(dto.getName());
        task.setCompleted(false);
        task.setLastChangeDate(LocalDateTime.now());
        task.setTaskSet(taskSetRepository.findById(dto.getTaskSetId()).orElse(new TaskSet()));
        return task;
    }

    public Task updateDtoToEntity(TaskUpdateDto dto) {
        Task task = taskRepository.findById(dto.getId()).orElse(new Task());
        task.setName(dto.getName());
        task.setLastChangeDate(LocalDateTime.now());
        task.setCompleted(dto.getCompleted());
        return task;
    }

    public TaskInfoDto entityToInfoDto(Task task){
        TaskInfoDto taskInfoDto = new TaskInfoDto();
        taskInfoDto.setId(task.getId());
        taskInfoDto.setName(task.getName());
        taskInfoDto.setCompleted(task.getCompleted());
        return taskInfoDto;
    }
}
