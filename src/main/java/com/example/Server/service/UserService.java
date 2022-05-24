package com.example.Server.service;

import com.example.Server.entity.UserEntity;
import com.example.Server.exception.UserAlreadyExistException;
import com.example.Server.exception.UserNotFoundException;
import com.example.Server.model.User;
import com.example.Server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity userAdd(UserEntity user) throws UserAlreadyExistException {
        if(userRepository.findByUsername(user.getUsername()) != null)
            throw new UserAlreadyExistException("User already exist");
        return userRepository.save(user);
    }

    public User getUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if(user == null)
            throw new UserNotFoundException("User not found");
        return User.toModel(user);
    }

    public Long deleteUser(Long id) throws UserNotFoundException{
        UserEntity user = userRepository.findById(id).get();
        if(user == null)
            throw new UserNotFoundException("User not found");
        userRepository.deleteById(id);
        return id;
    }
}
