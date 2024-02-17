package ru.geekbrains.homework9db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.homework9db.models.PcGame;

@Repository
public interface GameRepository extends JpaRepository<PcGame, Long> {



}
