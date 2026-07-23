package org.example.taskbackend.service;

import org.example.taskbackend.model.Task;
import org.example.taskbackend.model.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // 更新処理を追加
    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(taskDetails.isCompleted());
        task.setTitle(taskDetails.getTitle());
        task.setTaskMemo(taskDetails.getTaskMemo());
        return taskRepository.save(task);
    }

    // 削除処理を追加
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }
}