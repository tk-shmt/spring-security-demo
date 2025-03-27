package com.example.security_demo.entity;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Authority {
    private String id;
    private String userId; // usersテーブルのuser_idを参照
    private String authority;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}