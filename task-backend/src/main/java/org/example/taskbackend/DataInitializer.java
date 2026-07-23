package org.example.taskbackend;

import org.example.taskbackend.model.Task;
import org.example.taskbackend.model.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDatabase(TaskRepository repository) {
        return args -> {
            Task task1 = new Task();
            task1.setTitle("最初のタスク");
            task1.setTaskMemo("まずはここから始めよう");
            repository.save(task1);

            Task task2 = new Task();
            task2.setTitle("テストタスク");
            task2.setTaskMemo("H2データベースの確認用");
            repository.save(task2);
        };
    }
}