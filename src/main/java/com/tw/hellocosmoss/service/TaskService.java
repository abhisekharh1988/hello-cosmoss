package com.tw.hellocosmoss.service;

import com.tw.hellocosmoss.entity.Task;
import com.tw.hellocosmoss.model.DevTask;
import com.tw.hellocosmoss.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {

    public TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void create(DevTask task) {
        Task newTask = new Task(
                task.getId(),
                task.getTaskName(),
                task.getDeveloperName(),
                task.getStatus()
        );

        taskRepository.save(newTask);
    }

    public List<DevTask> getAllTasks() {
        return StreamSupport.stream(taskRepository.findAll().spliterator(), false)
                .map(task -> new DevTask(
                        task.getId(),
                        task.getTaskName(),
                        task.getDeveloperName(),
                        task.getStatus())
                ).collect(Collectors.toList());
    }
}
