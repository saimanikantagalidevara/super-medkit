package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email); // Custom query method to find a user by email

    boolean existsByEmail(String email);
    
    List<User> findByRole(String role);
    
    


}
