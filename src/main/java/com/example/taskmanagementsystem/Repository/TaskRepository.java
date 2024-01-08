package com.example.taskmanagementsystem.Repository;

import com.example.taskmanagementsystem.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
