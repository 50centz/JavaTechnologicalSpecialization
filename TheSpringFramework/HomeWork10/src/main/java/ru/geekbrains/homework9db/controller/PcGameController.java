package ru.geekbrains.homework9db.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework9db.models.PcGame;
import ru.geekbrains.homework9db.services.PcGameService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/PcGame")
public class PcGameController {

    private PcGameService pcGameService;

    @PostMapping("/add")
    public ResponseEntity<PcGame> createPcGame(@RequestBody PcGame pcGame){
        return pcGameService.createPcGame(pcGame);
    }

    @GetMapping("/allPcGame")
    public ResponseEntity<List<PcGame>> getAllGame(){
        return pcGameService.findAll();
    }


    @PutMapping("/update")
    public ResponseEntity<PcGame> updateNote(@RequestBody PcGame pcGame){
        return pcGameService.updatePcGame(pcGame);
    }

    @PutMapping("/delete")
    public ResponseEntity<Void> deleteNote(@RequestBody PcGame pcGame){
        return pcGameService.deletePcGame(pcGame);
    }
}
