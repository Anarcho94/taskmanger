package com.webcom.taskmanger.dto.taskset;

import com.webcom.taskmanger.dto.task.TaskUpdateDto;
import lombok.Data;

import java.util.List;

@Data
public class TaskSetUpdateDto {

    private String name;

    private List<TaskUpdateDto> tasks;
}
