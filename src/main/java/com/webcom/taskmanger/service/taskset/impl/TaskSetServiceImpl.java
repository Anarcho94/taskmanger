package com.webcom.taskmanger.service.taskset.impl;

import com.webcom.taskmanger.dto.taskset.TaskSetInfoDto;
import com.webcom.taskmanger.dto.taskset.TaskSetSaveDto;
import com.webcom.taskmanger.dto.taskset.TaskSetUpdateDto;
import com.webcom.taskmanger.entity.TaskSet;
import com.webcom.taskmanger.repository.TaskRepository;
import com.webcom.taskmanger.repository.TaskSetRepository;
import com.webcom.taskmanger.service.taskset.TaskSetService;
import com.webcom.taskmanger.service.taskset.transformer.TaskSetTransformer;
import com.webcom.taskmanger.service.task.transformer.TaskTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TaskSetServiceImpl implements TaskSetService {

    private final TaskSetRepository taskSetRepository;

    private final TaskRepository taskRepository;

    private final TaskSetTransformer taskSetTransformer;

    private final TaskTransformer taskTransformer;

    @Override
    public void save(TaskSetSaveDto taskSetSaveDto) {
        taskSetRepository.save(taskSetTransformer.toEntity(taskSetSaveDto));
    }

    @Override
    @Transactional
    public void update(TaskSetUpdateDto taskSetUpdateDto) {
        TaskSet taskSet = taskSetRepository.findByName(taskSetUpdateDto.getName());
        taskRepository.deleteAll(taskSet.getTasks());
        taskSet.setName(taskSetUpdateDto.getName());
        taskSet.setLastChangeDate(LocalDateTime.now());
        taskSet.setTasks(taskSetUpdateDto.getTasks().stream()
                .map(taskTransformer::updateDtoToEntity)
                .collect(Collectors.toList()));
        taskSetRepository.save(taskSet);
    }

    @Override
    public void delete(Long taskSetId) {
        TaskSet taskSet = taskSetRepository.findById(taskSetId).orElseThrow();
        taskSet.setDeleted(true);
        taskSetRepository.save(taskSet);
    }

    @Override
    public List<TaskSetInfoDto> getAllTaskSets() {
        return taskSetRepository.getAllTaskSets().stream()
                .map(taskSetTransformer::toTaskSetInfoDto)
                .collect(Collectors.toList());
    }
}
