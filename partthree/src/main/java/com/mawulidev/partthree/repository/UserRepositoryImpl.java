package com.mawulidev.partthree.repository;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository{
    private static final Map<Long, String> users = new HashMap<>();

    static {
        users.put(1L, "Alice");
        users.put(2L, "Bob");
        users.put(3L, "Charlie");
    }

    @Override
    public String getUserById(Long id) {
        return users.getOrDefault(id, "User not found");
    }

    @Override
    public void saveUser(Long id, String name) {
        users.put(id, name);
    }
}
