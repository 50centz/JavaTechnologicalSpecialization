package ru.geekbrains.homework5.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework5.models.Task;
import ru.geekbrains.homework5.models.TaskStatus;
import ru.geekbrains.homework5.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServices {
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }


    public void createTask(Task task){
        taskRepository.save(task);
    }


    public List<Task> findTasksByStatus(int status){
        List<Task> taskList =  taskRepository.findAll();
        if (status == 0){
            return taskList.stream().filter(task -> task.getTaskStatus() == TaskStatus.NOT_STARTED).toList();
        } else if (status == 1) {
            return taskList.stream().filter(task -> task.getTaskStatus() == TaskStatus.IN_PROGRESS).toList();
        } else {
            return taskList.stream().filter(task -> task.getTaskStatus() == TaskStatus.COMPLETED).toList();
        }
    }


    @Transactional
    public void updateTaskById(Task task){

        Task task1 = taskRepository.findById(task.getId()).get();
        task1.setDescription(task.getDescription());
        task1.setTaskStatus(task.getTaskStatus());
        taskRepository.save(task1);
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }


}
