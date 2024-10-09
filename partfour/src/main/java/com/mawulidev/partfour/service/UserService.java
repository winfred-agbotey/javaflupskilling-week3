package com.mawulidev.partfour.service;

import com.mawulidev.partfour.dto.UserDTO;
import com.mawulidev.partfour.model.User;

import java.util.Map;

public interface UserService {
    UserDTO createUser(UserDTO user);

    UserDTO getUserById(Long id);

    UserDTO updateUser(Long id, UserDTO user);

    boolean deleteUser(Long id);

    Map<Long, User> getAllUsers();

}
