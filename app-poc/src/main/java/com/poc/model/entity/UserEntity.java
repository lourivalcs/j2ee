package com.poc.model.entity;

import com.poc.model.dto.UserDTO;

import javax.persistence.*;

@Entity(name = "user_table")
@Table(name = "user_table")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", updatable = false, nullable = false)
    private long userId;
    @Column(name = "name")
    private String name;

    public UserEntity() {
    }

    public UserEntity(UserDTO userDTO) {
        this.name = userDTO.getName();
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
}
