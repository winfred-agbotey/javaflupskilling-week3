package com.mawulidev.parttwo.service;

import com.mawulidev.parttwo.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * UserService is a Spring-managed service bean that handles business logic.
 * It interacts with the UserRepository to fetch user data.
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves a user by ID using the UserRepository.
     * @param id the ID of the user
     * @return the name of the user
     */
    @Override
    public String getUserById(Long id) {
        return userRepository.getUserById(id);
    }
}
