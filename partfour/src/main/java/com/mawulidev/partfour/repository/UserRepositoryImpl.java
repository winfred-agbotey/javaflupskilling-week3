package com.mawulidev.partfour.repository;

import com.mawulidev.partfour.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    private Long nextId = 1L;

    /**
     * Create a new user and add to the in-memory map.
     */
    public User createUser(User user) {
        user.setId(nextId++);
        users.put(user.getId(), user);
        return user;
    }

    /**
     * Retrieve a user by their ID.
     */
    public User getUserById(Long id) {
        return users.get(id);
    }

    /**
     * Update an existing user by their ID.
     */
    public User updateUser(Long id, User updatedUser) {
        if (users.containsKey(id)) {
            updatedUser.setId(id);
            users.put(id, updatedUser);
            return updatedUser;
        }
        return null;
    }

    /**
     * Delete a user by their ID.
     */
    public boolean deleteUser(Long id) {
        return users.remove(id) != null;
    }

    /**
     * Get all users.
     */
    public Map<Long, User> getAllUsers() {
        return users;
    }
}
