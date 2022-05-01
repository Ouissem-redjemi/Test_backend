package com.test.tfjtest.controller;

import com.test.tfjtest.model.User;
import com.test.tfjtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userServ;

    @PostMapping("/user/add")
    public String add(@RequestBody User user){
        userServ.saveUser(user);
        return "Nouvelle personne ajoutée";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userServ.getUsers();
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User newUser){
        User updatedUser = userServ.saveUser(newUser);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id")  int id){
        userServ.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userServ.getUserById(id);
    }
}
