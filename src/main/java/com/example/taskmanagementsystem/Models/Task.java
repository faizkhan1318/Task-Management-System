package com.example.taskmanagementsystem.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name = "task")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Title;
    private Date date;
    private String status;

    @ManyToOne
    private User user;
}
