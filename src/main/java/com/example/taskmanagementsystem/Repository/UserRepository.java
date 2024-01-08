package com.example.taskmanagementsystem.Repository;

import com.example.taskmanagementsystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
