package org.example.taskbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tasks") // データベースのテーブル名
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDを自動採番する設定
    private Long id;

    @Column(nullable = false) // 必須項目
    private String title;

    @Column(columnDefinition = "TEXT") // メモ用（長い文章対応）
    private String taskMemo;

    private boolean isCompleted = false; // デフォルト値：未完了
}