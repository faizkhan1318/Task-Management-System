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
public class UserTaskResponseDto {

    private String title;
    private Date date;
    private String status;
}
