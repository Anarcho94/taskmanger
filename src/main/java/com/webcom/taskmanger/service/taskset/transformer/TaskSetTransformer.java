package com.webcom.taskmanger.service.taskset.transformer;

import com.webcom.taskmanger.dto.task.TaskInfoDto;
import com.webcom.taskmanger.dto.taskset.TaskSetInfoDto;
import com.webcom.taskmanger.dto.taskset.TaskSetSaveDto;
import com.webcom.taskmanger.entity.TaskSet;
import com.webcom.taskmanger.service.task.transformer.TaskTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TaskSetTransformer {

    private final TaskTransformer taskTransformer;

    public TaskSet toEntity(TaskSetSaveDto dto) {
        TaskSet taskSet = new TaskSet();
        taskSet.setLastChangeDate(LocalDateTime.now());
        taskSet.setName(dto.getName());
        return taskSet;
    }

    public TaskSetInfoDto toTaskSetInfoDto(TaskSet taskSet) {
        TaskSetInfoDto taskSetInfoDto = new TaskSetInfoDto();
        taskSetInfoDto.setId(taskSet.getId());
        taskSetInfoDto.setName(taskSet.getName());
        taskSetInfoDto.setList(taskSet.getTasks().stream()
                .map(taskTransformer::entityToInfoDto).sorted(Comparator.comparing(TaskInfoDto::getCompleted))
                .collect(Collectors.toList()));
        return taskSetInfoDto;
    }
}
