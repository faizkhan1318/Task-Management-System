package com.example.taskmanagementsystem.Dtos.ResponseDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDto {

    private Long userId;
    private String title;
    private String status;
    private Date date;
    private String responseStatus;
}
