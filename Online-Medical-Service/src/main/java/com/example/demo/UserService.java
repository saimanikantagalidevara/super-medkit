package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save user to the database
    public void saveUser(User user) {
        userRepository.save(user);
    }

    // Authenticate user by email and password
    public boolean authenticateUser(String email, String password, String role) {
        // Check if the user exists and credentials match
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password) && user.getRole().equals(role)) {
            return true;
        }
        return false;
    }
    

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<User> getDoctors() {
        return userRepository.findByRole("doctor");
    }
    
}
