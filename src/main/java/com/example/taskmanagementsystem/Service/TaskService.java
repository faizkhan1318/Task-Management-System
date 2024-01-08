package com.example.taskmanagementsystem.Service;

import com.example.taskmanagementsystem.Dtos.RequestDtos.AddTaskDto;
import com.example.taskmanagementsystem.Dtos.RequestDtos.UpdateTaskDto;
import com.example.taskmanagementsystem.Dtos.ResponseDto.TaskResponseDto;
import com.example.taskmanagementsystem.Dtos.ResponseDto.UserTaskResponseDto;
import com.example.taskmanagementsystem.Exceptions.TaskNotFound;
import com.example.taskmanagementsystem.Exceptions.UserNotFoundException;
import com.example.taskmanagementsystem.Models.Task;
import com.example.taskmanagementsystem.Models.User;
import com.example.taskmanagementsystem.Repository.TaskRepository;
import com.example.taskmanagementsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;
    public TaskResponseDto addTask(AddTaskDto addTaskDto) throws UserNotFoundException{
        Optional<User> userOptional = userRepository.findById(addTaskDto.getUserId());
        if (userOptional.isEmpty()){
            throw new UserNotFoundException("User Not Found");
        }
        User user = userOptional.get();

        Task task = new Task();
        task.setTitle(addTaskDto.getTitle());
        task.setStatus(addTaskDto.getStatus());
        task.setDate(addTaskDto.getDate());

        task.setUser(user);
        task = taskRepository.save(task);

        user.getTaskList().add(task);
        userRepository.save(user);

        TaskResponseDto taskResponseDto = TaskResponseDto.builder()
                .userId(addTaskDto.getUserId())
                .title(addTaskDto.getTitle())
                .status(addTaskDto.getStatus())
                .date(addTaskDto.getDate()).build();

        return taskResponseDto;

    }

    public List<UserTaskResponseDto> getAllTask(Long userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User Not Found");
        }
        List<Task> taskList= userOptional.get().getTaskList();
        List<UserTaskResponseDto> userTaskList = new ArrayList<>();

        for(Task task : taskList){
            UserTaskResponseDto userTaskResponseDto = UserTaskResponseDto.builder()
                    .title(task.getTitle())
                    .status(task.getStatus())
                    .date(task.getDate())
                    .build();
            userTaskList.add(userTaskResponseDto);
        }

        return userTaskList;

    }

    public TaskResponseDto updateTask(Long taskId, UpdateTaskDto updateTaskDto) throws TaskNotFound {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if(taskOptional.isEmpty()){
            throw new TaskNotFound("Task Id is Incorrect");
        }
        Task task = taskOptional.get();

        task.setTitle(updateTaskDto.getTitle());
        task.setStatus(updateTaskDto.getStatus());
        task.setDate(updateTaskDto.getDate());

        User user = task.getUser();
        task = taskRepository.save(task);

        user.getTaskList().add(task);
        userRepository.save(user);

        TaskResponseDto taskResponseDto = TaskResponseDto.builder()
                .userId(user.getId())
                .title(updateTaskDto.getTitle())
                .status(updateTaskDto.getStatus())
                .date(updateTaskDto.getDate()).build();

        return taskResponseDto;
    }

    public void deleteTask(Long taskId) throws TaskNotFound {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if(taskOptional.isEmpty()){
            throw new TaskNotFound("Task id is not Present");
        }
        taskRepository.deleteById(taskId);
    }
}
