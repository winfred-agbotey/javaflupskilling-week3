package com.mawulidev.partthree.repository;

public interface UserRepository {
    String getUserById(Long id);
    void saveUser(Long id, String name);
}
