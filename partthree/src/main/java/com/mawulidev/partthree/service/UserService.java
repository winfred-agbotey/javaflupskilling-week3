package com.mawulidev.partthree.service;

public interface UserService {
    String getUserById(Long id);

    void createUser(Long id, String name);
}
