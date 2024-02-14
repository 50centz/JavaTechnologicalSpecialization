package ru.geekbrains.homework9db.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework9db.models.PcGame;
import ru.geekbrains.homework9db.repository.GameRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PcGameService {

    private GameRepository gameRepository;


    public ResponseEntity<PcGame> createPcGame(PcGame pcGame){
        try {
            return new ResponseEntity<>(gameRepository.save(pcGame), HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PcGame());
        }
    }


    public ResponseEntity<List<PcGame>> findAll(){
        return new ResponseEntity<>(gameRepository.findAll(), HttpStatus.OK);
    }


    public ResponseEntity<PcGame> updatePcGame(PcGame pcGame){
        PcGame pcGameUpdate;
        try {
            pcGameUpdate = gameRepository.findById(pcGame.getId()).orElseThrow();
            pcGameUpdate.setPrice(pcGame.getPrice());
            pcGameUpdate.setTitle(pcGame.getTitle());
            gameRepository.save(pcGameUpdate);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PcGame());
        }
        return new ResponseEntity<>(pcGameUpdate, HttpStatus.OK);
    }

    public ResponseEntity<Void> deletePcGame(PcGame pcGame){
        gameRepository.deleteById(pcGame.getId());
        return ResponseEntity.ok().build();
    }



}


