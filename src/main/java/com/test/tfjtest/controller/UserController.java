package com.test.tfjtest.controller;

import com.test.tfjtest.model.User;
import com.test.tfjtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userServ;

    @PostMapping("/add")
    public String add(@RequestBody User user){
        userServ.saveUser(user);
        return "Nouvelle personne ajoutée";
    }

    @GetMapping("/getAll")
    public List<User> getUsers(){
        return userServ.getUsers();
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User user){
        User currentUser = userServ.getUserById(id);
        if (currentUser != null){
            String firstname = user.getFirst_name();
            String lastname = user.getLastname();
            if (firstname != null) {
                currentUser.setFirst_name(firstname);
            }
            if (lastname != null) {
                currentUser.setLastname(lastname);
            }

        }
        return currentUser;
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") final int id){
        userServ.deleteUser(id);
    }
}
