package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.User;

/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
