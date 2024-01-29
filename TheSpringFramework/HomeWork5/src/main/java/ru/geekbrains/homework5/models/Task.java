package ru.geekbrains.homework5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private String description;
    @Column(name = "task_status")
    @Enumerated(EnumType.ORDINAL)
    private TaskStatus taskStatus;
    @CreationTimestamp
    @Column(name = "local_date_time")
    private LocalDateTime dateOfCreated ;


}
