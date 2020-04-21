package com.webcom.taskmanger.controller;

import com.webcom.taskmanger.dto.task.TaskInfoDto;
import com.webcom.taskmanger.dto.task.TaskSaveDto;
import com.webcom.taskmanger.dto.task.TaskUpdateDto;
import com.webcom.taskmanger.service.task.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/save")
    public void saveTask(@RequestBody TaskSaveDto taskSaveDto) {
        taskService.saveTask(taskSaveDto);
    }

    @PostMapping("/update")
    public void updateTask(@RequestBody TaskUpdateDto taskUpdateDto) {
        taskService.updateTask(taskUpdateDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }


}
