package com.thomas.forum.contoller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.thomas.forum.model.User;

public interface GovOperation {


    @GetMapping(value = "/users")
    List<User> getUsers();

    @GetMapping(value = "/user")
    User getUser(@RequestParam(value = "id") int num);

    

}
