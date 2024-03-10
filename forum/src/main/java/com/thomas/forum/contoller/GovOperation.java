package com.thomas.forum.contoller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.thomas.forum.model.User;

public interface GovOperation {
    

    @GetMapping(value = "/users")
    List<User> getUsers(); 

    
    
}
