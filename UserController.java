package com.example.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.UserModel;
import com.example.user.services.UserService;


@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service)
    {
        this.service = service;
    }

    @GetMapping(path = "/users")
    public List<UserModel> getAllUsers()
    {
        return service.getAllUsers();
    }

    @PostMapping("/users")
    public UserModel postMethodName(@RequestBody UserModel user) {
        
        return service.saveUser(user);
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }

    @PutMapping(path = "/users/{id}/update")
    public void updateUser(@PathVariable Long id, @RequestBody UserModel user) //Take the incoming HTTP request body, Convert (deserialize) that JSON into a Java object, Pass it to your controller method as a parameter
    {
        service.updateUser(user, id);
    }
    

}
