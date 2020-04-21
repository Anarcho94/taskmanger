package com.webcom.taskmanger.service.taskset;

import com.webcom.taskmanger.dto.taskset.TaskSetInfoDto;
import com.webcom.taskmanger.dto.taskset.TaskSetSaveDto;
import com.webcom.taskmanger.dto.taskset.TaskSetUpdateDto;

import java.util.List;

public interface TaskSetService {

    void save(TaskSetSaveDto taskSetSaveDto);

    void update(TaskSetUpdateDto taskSetUpdateDto);

    void delete(Long taskSetId);

    List<TaskSetInfoDto> getAllTaskSets();
}
