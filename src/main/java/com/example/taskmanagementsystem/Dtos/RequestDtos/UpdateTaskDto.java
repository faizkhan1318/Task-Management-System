package com.example.taskmanagementsystem.Dtos.RequestDtos;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateTaskDto {

    private Long id; //taskId

    private String title;

    private String status;
    private Date date;

}
