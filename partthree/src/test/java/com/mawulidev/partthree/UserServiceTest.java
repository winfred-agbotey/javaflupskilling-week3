package com.mawulidev.partthree;

import com.mawulidev.partthree.repository.UserRepository;
import com.mawulidev.partthree.service.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserServiceTest {
    private static AutoCloseable closeable;

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

//    @Before
//    public void openMocks() {
//        closeable = MockitoAnnotations.openMocks(this);
//    }
//
//    @After
//    public void releaseMocks() throws Exception {
//        closeable.close();
//    }

    @Test
    public void testCreateUser() {
        Long userId = 5L;
        String userName = "David";

        userService.createUser(userId, userName);

        verify(userRepository, times(1)).saveUser(userId, userName);

        when(userRepository.getUserById(userId)).thenReturn(userName);
        String actualUserName = userService.getUserById(userId);

        assertEquals(userName, actualUserName);
    }

    @Test
    public void testFindUserById_ExistingUser() {
        Long userId = 1L;
        String expectedUserName = "Alice";
        when(userRepository.getUserById(userId)).thenReturn(expectedUserName);

        String actualUserName = userService.getUserById(userId);

        assertEquals(expectedUserName, actualUserName);

        verify(userRepository).getUserById(userId);
    }

    @Test
    public void testFindUserById_NonExistingUser() {

        Long userId = 4L;
        String expectedResponse = "User not found";
        when(userRepository.getUserById(userId)).thenReturn(expectedResponse);


        String actualResponse = userService.getUserById(userId);


        assertEquals(expectedResponse, actualResponse);


        verify(userRepository).getUserById(userId);
    }
}
