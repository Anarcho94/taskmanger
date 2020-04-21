package com.webcom.taskmanger.dto.taskset;

import com.webcom.taskmanger.dto.task.TaskInfoDto;
import lombok.Data;

import java.util.List;

@Data
public class TaskSetInfoDto {

    private Long id;

    private String name;

    private List<TaskInfoDto> list;
}
