package com.example.user.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.user.model.UserModel;
import com.example.user.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository)
    {
        this.repository = repository;
    }

    public List<UserModel> getAllUsers()
    {
        return repository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return repository.save(user);
    }

    public void deleteUser(Long id)
    {
        repository.deleteById(id);
    }

    public void updateUser(UserModel user, Long id){
        UserModel currentUser = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        currentUser.setName(user.getName());
        currentUser.setEmail(user.getEmail());
        repository.save(currentUser);
    }
}
