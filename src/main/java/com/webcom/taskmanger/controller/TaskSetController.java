package com.webcom.taskmanger.controller;

import com.webcom.taskmanger.dto.taskset.TaskSetInfoDto;
import com.webcom.taskmanger.dto.taskset.TaskSetSaveDto;
import com.webcom.taskmanger.dto.taskset.TaskSetUpdateDto;
import com.webcom.taskmanger.service.taskset.TaskSetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-set")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class TaskSetController {

    private final TaskSetService taskSetService;

    @PostMapping("/save")
    public TaskSetSaveDto saveTaskSet(@RequestBody TaskSetSaveDto saveDto){
        taskSetService.save(saveDto);
        return saveDto;
    }

    @PostMapping("/update")
    public TaskSetUpdateDto updateTaskSet(@RequestBody TaskSetUpdateDto updateDto){
        taskSetService.update(updateDto);
        return updateDto;
    }

    @DeleteMapping("/delete/{taskSetId}")
    public void deleteTaskSet(@PathVariable Long taskSetId){
        taskSetService.delete(taskSetId);
    }

    @GetMapping("/get-task-sets")
    public List<TaskSetInfoDto> getAllTaskSets(){
        return taskSetService.getAllTaskSets();
    }
}
