package com.mawulidev.parttwo.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * UserRepositoryImpl is a concrete implementation of the UserRepository interface.
 * It simulates in-memory storage of user data.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final Map<Long, String> users = new HashMap<>();

    static {
        users.put(1L, "Alice");
        users.put(2L, "Bob");
        users.put(3L, "Charlie");
    }


    @Override
    public String getUserById(Long id) {
        // Fetch the username by ID, returns "User not found" if the ID is not present in the map
        return users.getOrDefault(id, "User not found");
    }
}
