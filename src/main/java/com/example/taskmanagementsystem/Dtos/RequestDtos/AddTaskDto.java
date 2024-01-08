package com.example.taskmanagementsystem.Dtos.RequestDtos;

import lombok.Data;

import java.util.Date;

@Data
public class AddTaskDto {
    private Long userId;
    private String title;
    private Date date;
    private String status;
}
