package com.example.demo.controllers;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.models.UserRepository;
import com.example.demo.models.User;
import static org.mockito.Mockito.when;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebMvcTest(UsersController.class)
public class UsersControllerTest {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
    
    @MockBean
    private UserRepository userRepository;
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllUsers() throws Exception {

        User u1 = new User();
        u1.setName("bobby");
        u1.setPassword("1234");
        u1.setSize(42);

        User u2 = new User();
        u2.setName("jane");
        u2.setPassword("1234");
        u2.setSize(25);

        List<User> users = new ArrayList<User>();
        users.add(u1);
        users.add(u2);

        when(userRepository.findAll()).thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/view"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("showAll"))
            
            .andExpect(MockMvcResultMatchers.model().attribute("us", hasItem(
                allOf(
                    hasProperty("name", Matchers.is("bobby")),
                    hasProperty("password", Matchers.is("1234")),
                    hasProperty("size", Matchers.is(42))
                )
            )));
    }
    
    @Test
    void testGetLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("login"));
    } 

    

}
