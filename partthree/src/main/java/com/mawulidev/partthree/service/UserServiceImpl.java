package com.mawulidev.partthree.service;

import com.mawulidev.partthree.repository.UserRepository;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void createUser(Long id, String name) {
        userRepository.saveUser(id, name);
    }
}
