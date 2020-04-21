package com.webcom.taskmanger.service.task;

import com.webcom.taskmanger.dto.task.TaskSaveDto;
import com.webcom.taskmanger.dto.task.TaskUpdateDto;

public interface TaskService {

    void saveTask(TaskSaveDto taskSaveDto);

    void updateTask(TaskUpdateDto taskUpdateDto);

    void deleteTask(Long taskId);
}
