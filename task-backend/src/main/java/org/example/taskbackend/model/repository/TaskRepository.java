package org.example.taskbackend.model.repository;

import org.example.taskbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // これだけで、保存、検索、削除などの基本機能がすべて使えるようになります！
}