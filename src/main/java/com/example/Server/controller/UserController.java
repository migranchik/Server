package com.example.Server.controller;

import com.example.Server.entity.UserEntity;
import com.example.Server.exception.UserAlreadyExistException;
import com.example.Server.exception.UserNotFoundException;
import com.example.Server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity addUser(@RequestBody UserEntity user) {
        try {
            userService.userAdd(user);
            return ResponseEntity.ok("User sucsessfully added");
        } catch (UserAlreadyExistException userAlreadyExistException){
            return ResponseEntity.badRequest().body(userAlreadyExistException.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("LOL");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try{
            return ResponseEntity.ok(userService.getUser(id));
        } catch(UserNotFoundException userNotFoundException){
            return ResponseEntity.badRequest().body(userNotFoundException.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try{
            return ResponseEntity.ok(userService.deleteUser(id));
        } catch(UserNotFoundException userNotFoundException){
            return ResponseEntity.badRequest().body(userNotFoundException.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
