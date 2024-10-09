package com.mawulidev.partfour.repository;

import com.mawulidev.partfour.model.User;

import java.util.Map;

public interface UserRepository {
    User createUser(User user);

    User getUserById(Long id);

    User updateUser(Long id, User updatedUser);

    boolean deleteUser(Long id);

    Map<Long, User> getAllUsers();


}
