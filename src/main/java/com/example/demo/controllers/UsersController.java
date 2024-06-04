package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.User;
import com.example.demo.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;



@Controller
public class UsersController {  
    
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users/view")
    public String getAllUsers(Model model){
        System.out.println("Getting all users");
        // get all users from database
        /* 
        List <User> users = new ArrayList<>();
        users.add(new User("Alice","123",25));
        users.add(new User("Bobby","456",6));
        users.add(new User("Charlie,","789",7));
        users.add(new User("David","101",8));
        users.add(new User("Steve","112",19));
        */ 
        List<User> users = userRepo.findAll();
        // end of database call
        model.addAttribute("us", users);
        return "showAll";
    }

    @GetMapping("/users/view/{uid}")
    public String getUser(Model model, @PathVariable String uid){
        
        System.out.println("GET User " + uid);
        // call db
        
        return "showUser";
    }

    // data coming from form would be a PostMapping
    @PostMapping("/users/add")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response){
        System.out.println("ADD user");
        String newName = newuser.get("name");
        String newPwd = newuser.get("password");
        int newSize = Integer.parseInt(newuser.get("size"));
        userRepo.save(new User(newName,newPwd,newSize));
        response.setStatus(201);
        return "addedUser";
    }

}
