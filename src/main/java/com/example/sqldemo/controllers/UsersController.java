package com.example.sqldemo.controllers;

import com.example.sqldemo.models.Users;
import com.example.sqldemo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public Iterable<Users> readAll(){
        return usersService.getAllUsers();
    }


    @GetMapping("/users/{id}")
    public Optional<Users> readOneById(@PathVariable Long id){
        return usersService.getById(id);
    }

    @PostMapping("/users")
    public Users create(@RequestBody Users user){
        return usersService.create(user);
    }


    @PutMapping("/users/{id}")
    public Users update(@RequestBody Users user, @PathVariable Long id){
        return usersService.update(user, id);

        //return ResponseEntity.status(HttpStatus.ACCEPTED).body("Correcto");
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        usersService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Correcto");
    }
}
