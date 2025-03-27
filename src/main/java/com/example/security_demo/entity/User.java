package com.example.security_demo.entity;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "password")
public class User {
    private String id;
    private String userId;
    private String password;
    private boolean enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Authority> authorities;
}