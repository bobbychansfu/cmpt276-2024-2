package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.demo.models.User;



@Controller
public class UsersController {  
    

    @GetMapping("/users/view")
    public String getAllUsers(Model model){
        System.out.println("Getting all users");
        // get all users from database
        List <User> users = new ArrayList<>();
        users.add(new User("Alice","123",25));
        users.add(new User("Bobby","456",6));
        users.add(new User("Charlie,","789",7));
        users.add(new User("David","101",8));
        users.add(new User("Steve","112",19));
        // end of database call
        model.addAttribute("us", users);
        return "showAll";
    }

}
