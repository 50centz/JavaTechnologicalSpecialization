package ru.geekbrains.homework12.controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework12.enums.TypePcGame;
import ru.geekbrains.homework12.models.PcGame;
import ru.geekbrains.homework12.models.StrategyPcGame;
import ru.geekbrains.homework12.service.FileGateway;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/PcGame")
public class PcGameController {


    private FileGateway fileGateway;


    @PostMapping("/add/{typePcGame}")
    public ResponseEntity<PcGame> createPcGame(@PathVariable("typePcGame")TypePcGame typePcGame, @RequestBody PcGame pcGame){

        switch (typePcGame.toString()){
            case "SHOOTER":
                fileGateway.writeToFile("SHOOTER" + ".txt", pcGame.toString());
                return new ResponseEntity<>(HttpStatus.OK);
            case "STRATEGY":
                StrategyPcGame strategyPcGame = new StrategyPcGame();
                strategyPcGame.setTitle(pcGame.getTitle());
                strategyPcGame.setPrice(pcGame.getPrice());
                strategyPcGame.setTypePcGame(typePcGame);
                fileGateway.writeToFile("STRATEGY" + ".txt", strategyPcGame.toString());
                return new ResponseEntity<>(HttpStatus.OK);
            case "ACTION":
                fileGateway.writeToFile("ACTION" + ".txt", pcGame.toString());
                return new ResponseEntity<>(HttpStatus.OK);
            default:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}
