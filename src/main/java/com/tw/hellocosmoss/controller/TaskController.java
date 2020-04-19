package com.tw.hellocosmoss.controller;

import com.tw.hellocosmoss.model.DevTask;
import com.tw.hellocosmoss.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    public TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody DevTask task) {
        taskService.create(task);
    }

    @GetMapping
    public List<DevTask> getAll() {
        return taskService.getAllTasks();
    }
}
