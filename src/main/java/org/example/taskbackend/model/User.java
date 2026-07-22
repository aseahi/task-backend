package org.example.taskbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users") // ユーザー用テーブル
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) // 重複を許さない
    private String username; // ログインIDとして使用

    @Column(nullable = false)
    private String password;
}