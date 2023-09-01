package day3.mocking;

import day3.mocking.sample1.UserManager;
import day3.mocking.sample1.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    void getUserByIdTest(){

        //UserService i test ederken UserManagerdan bağımsız olması için
        //gerçek UserManager yerine mock(sahte) bir obje oluşturduk.
        UserManager userManager=mock(UserManager.class);

        //userManagerın getUser metodu çağrıldığında(when) ... değeri döndür(thenReturn) diyoruz.
        when(userManager.getUser(1)).thenReturn("Jack Sparrow");

        UserService userService=new UserService(userManager);

        //getUserById 1 parametresi ile test

        String actualUser=userService.getUserById(1);

        assertEquals("User Jack Sparrow",actualUser);
        assertNotNull(actualUser);
        verify(userManager,times(1)).getUser(1);


    }

    //getUserById metodunun test senaryolarında
    //1-return user + isim
    //2-return null olmamalı
    //3-getUser metodunu çağırıyor mu





}
