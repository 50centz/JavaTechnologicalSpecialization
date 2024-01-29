package ru.geekbrains.homework5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.geekbrains.homework5.models.Task;
import ru.geekbrains.homework5.models.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

//    @Modifying
//    @Query("update task t set t.description = :description, t.status = :status where t.id = :id")
//    void updateTaskById(@Param("description") String description, @Param("id") int status, @Param("id") Long id);

}
