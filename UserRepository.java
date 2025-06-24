package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
