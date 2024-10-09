package com.mawulidev.partfour;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mawulidev.partfour.dto.UserDTO;
import com.mawulidev.partfour.model.User;
import com.mawulidev.partfour.repository.UserRepository;
import com.mawulidev.partfour.service.UserService;
import com.mawulidev.partfour.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ObjectMapper mapper;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    private UserDTO userDTO;

    @Before
    public void setUp() {
        // Initialize a User and a UserDTO
        user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john@example.com");

        userDTO = new UserDTO();
        userDTO.setName("John Doe");
        userDTO.setEmail("john@example.com");
    }

    @Test
    public void testCreateUser() {
        // Mock conversion of UserDTO to User
        when(mapper.convertValue(userDTO, User.class)).thenReturn(user);
        // Mock saving the user
        when(userRepository.createUser(user)).thenReturn(user);
        // Mock conversion of User back to UserDTO
        when(mapper.convertValue(user, UserDTO.class)).thenReturn(userDTO);

        UserDTO result = userService.createUser(userDTO);

        assertNotNull(result);
        assertEquals(userDTO.getName(), result.getName());
        assertEquals(userDTO.getEmail(), result.getEmail());

        // Verify that the repository's createUser method was called
        verify(userRepository, times(1)).createUser(user);
        verify(mapper, times(1)).convertValue(userDTO, User.class);
        verify(mapper, times(1)).convertValue(user, UserDTO.class);
    }

    @Test
    public void testGetUserById() {
        Long userId = 1L;
        // Mock fetching a user by ID
        when(userRepository.getUserById(userId)).thenReturn(user);
        // Mock conversion of User to UserDTO
        when(mapper.convertValue(user, UserDTO.class)).thenReturn(userDTO);

        UserDTO result = userService.getUserById(userId);

        assertNotNull(result);
        assertEquals(userDTO.getName(), result.getName());
        assertEquals(userDTO.getEmail(), result.getEmail());

        verify(userRepository, times(1)).getUserById(userId);
        verify(mapper, times(1)).convertValue(user, UserDTO.class);
    }

    @Test
    public void testUpdateUser() {
        Long userId = 1L;
        // Mock conversion of UserDTO to User
        when(mapper.convertValue(userDTO, User.class)).thenReturn(user);
        // Mock updating the user
        when(userRepository.updateUser(userId, user)).thenReturn(user);
        // Mock conversion of User back to UserDTO
        when(mapper.convertValue(user, UserDTO.class)).thenReturn(userDTO);

        UserDTO result = userService.updateUser(userId, userDTO);

        assertNotNull(result);
        assertEquals(userDTO.getName(), result.getName());
        assertEquals(userDTO.getEmail(), result.getEmail());

        verify(userRepository, times(1)).updateUser(userId, user);
        verify(mapper, times(1)).convertValue(userDTO, User.class);
        verify(mapper, times(1)).convertValue(user, UserDTO.class);
    }

    @Test
    public void testDeleteUser() {
        Long userId = 1L;
        // Mock deleting a user by ID
        when(userRepository.deleteUser(userId)).thenReturn(true);

        boolean result = userService.deleteUser(userId);

        assertTrue(result);

        verify(userRepository, times(1)).deleteUser(userId);
    }

    @Test
    public void testGetAllUsers() {
        // Mock returning all users
        when(userRepository.getAllUsers()).thenReturn(Map.of(1L, user));

        Map<Long, User> result = userService.getAllUsers();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.containsKey(1L));
        assertEquals(user.getName(), result.get(1L).getName());

        verify(userRepository, times(1)).getAllUsers();
    }
}
