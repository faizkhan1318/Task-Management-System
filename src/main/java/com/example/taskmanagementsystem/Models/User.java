package com.example.taskmanagementsystem.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String mobNo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> taskList = new ArrayList<>();
}
