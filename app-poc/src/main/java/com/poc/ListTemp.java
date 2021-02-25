package com.poc;

import com.poc.model.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTemp {
    private static List<UserDTO> userDTOS = getUsers();

    public static List<UserDTO> getUsers() {
        if (userDTOS == null) {
            userDTOS = new ArrayList<>();

            for (int i = 0; i < 20; i++) {
                userDTOS.add(new UserDTO(i, "User " + i, i));
            }
        }

        return userDTOS;
    }

    public static void addUser(UserDTO user) {
        userDTOS.add(user);
    }

    public static void updateUser(UserDTO user) {
        deleteUser(user.getUserId());
        addUser(user);
    }

    public static void deleteUser(long userId) {
        userDTOS.removeIf(f -> f.getUserId() == userId);
    }
}
