package com.tw.hellocosmoss.repository;

import com.tw.hellocosmoss.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, String> {

    List<Task> getTasksByStatus(String status);
}
