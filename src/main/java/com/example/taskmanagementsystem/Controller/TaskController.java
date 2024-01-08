package com.example.taskmanagementsystem.Controller;

import com.example.taskmanagementsystem.Dtos.RequestDtos.AddTaskDto;
import com.example.taskmanagementsystem.Dtos.RequestDtos.UpdateTaskDto;
import com.example.taskmanagementsystem.Dtos.ResponseDto.TaskResponseDto;
import com.example.taskmanagementsystem.Dtos.ResponseDto.UserTaskResponseDto;
import com.example.taskmanagementsystem.Models.Task;
import com.example.taskmanagementsystem.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("/addTask")
    public ResponseEntity<TaskResponseDto> addTask(@RequestBody AddTaskDto addTaskDto){

        try{
            TaskResponseDto taskResponseDto = taskService.addTask(addTaskDto);
            taskResponseDto.setResponseStatus("Task Added Successfully");
            return new ResponseEntity<>(taskResponseDto, HttpStatus.CREATED);
        }catch (Exception e){
            TaskResponseDto taskResponse = new TaskResponseDto();
            taskResponse.setResponseStatus(e.getMessage());
            return new ResponseEntity<>(taskResponse, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/allTask/{id}")
    public ResponseEntity<List<UserTaskResponseDto>> allTask(@PathVariable("id") Long userId){
            try{
                List<UserTaskResponseDto> response = taskService.getAllTask(userId);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
    }


    @PutMapping("/updateTask/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable("id") Long taskId, @RequestBody UpdateTaskDto updateTaskDto){
        try{
            TaskResponseDto response = taskService.updateTask(taskId, updateTaskDto);
            response.setResponseStatus("Update Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            TaskResponseDto taskResponse = new TaskResponseDto();
            taskResponse.setResponseStatus(e.getMessage());
            return new ResponseEntity<>(taskResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long taskId){
        try
        {
            taskService.deleteTask(taskId);
            return new ResponseEntity<>("Task Deleted Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
