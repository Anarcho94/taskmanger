package com.webcom.taskmanger.dto.task;

import lombok.Data;

@Data
public class TaskInfoDto {

    private Long id;

    private String name;

    private Boolean completed;
}
