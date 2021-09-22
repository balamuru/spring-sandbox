package com.vgb.boot.sandbox.testable.a;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    NameService nameService;

    @Spy
    @InjectMocks
    UserService userService;


    @Test
    void getUserName() {
        when(nameService.getName(anyString())).thenReturn("foo");
        assertEquals("foo", userService.getUserName("123"));
        verify(nameService, times(1)).getName("123");
    }

    @Test
    void getUserNameUsingSpy() {
        doReturn("abc123").when(userService).getUserName("1");
        assertEquals("abc123", userService.getUserName("1"));
        verify(userService, times(1)).getUserName("1");
    }

    @Test
    void getUserNameUsingSpy2() {
        doReturn("abc123").when(userService).getUserName("1");
        when(userService.getUserName("1")).thenReturn("abc123");
        assertEquals("abc123", userService.getUserName("1"));
        verify(userService, times(1)).getUserName("1");
    }


    @Test
    void getRandomUserName() {
        MockedStatic<UUID> mockUUID = mockStatic(UUID.class);
        mockUUID.when(UUID::randomUUID).thenReturn(new UUID(1, 1));
        assertEquals("00000000-0000-0001-0000-000000000001", userService.getRandomUserName());
    }

    @Test
    void capitalize() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            {
                userService.capitalize(null);
            }
        });
        assertTrue(exception instanceof NullPointerException);

    }
}