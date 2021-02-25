package com.poc.model.dto;

public class UserDTO {
    private long userId;
    private String name;
    private int age;
    private String gender;
    private String email;

    public UserDTO() {
    }

    public UserDTO(long userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
