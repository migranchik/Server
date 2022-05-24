package com.example.Server.model;

import com.example.Server.entity.UserEntity;

public class User {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String description;
    private String icon;
    private int count_files;

    public User() {

    }

    public static User toModel(UserEntity user){
        User userModel = new User();

        userModel.setId(user.getId());
        userModel.setName(user.getName());
        userModel.setSurname(user.getSurname());
        userModel.setUsername(user.getUsername());
        userModel.setCount_files(user.getCount_files());
        userModel.setDescription(user.getDescription());
        userModel.setIcon(user.getIcon());

        return userModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getCount_files() {
        return count_files;
    }

    public void setCount_files(int count_files) {
        this.count_files = count_files;
    }
}
