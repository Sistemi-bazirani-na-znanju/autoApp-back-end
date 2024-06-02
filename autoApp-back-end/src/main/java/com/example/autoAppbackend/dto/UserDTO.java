package com.example.autoAppbackend.dto;

import lombok.Data;
import com.example.autoAppbackend.model.User;

@Data
public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private boolean isNew;
    private boolean isSuspicious;

    public UserDTO(User user) {
        this(user.getId(), user.getEmail(), user.getPassword(), user.getFirstName(),user.getLastName(), user.getRole().getName(), user.isSuspicious());
    }

    public UserDTO(Long id, String email, String password, String firstName, String lastName, String role, boolean isSuspicious) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.isSuspicious = isSuspicious;
    }
}
