package ru.geekbrains.homework9db;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.geekbrains.homework9db.models.PcGame;
import ru.geekbrains.homework9db.repository.GameRepository;
import ru.geekbrains.homework9db.services.PcGameService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@SpringBootTest
public class PcGameServiceIntegrationTest {


    @MockBean
    private GameRepository gameRepository;

    @Autowired
    private PcGameService pcGameService;

    @Test
    public void createPcGame(){
        PcGame pcGame = new PcGame();
        pcGame.setTitle("SnowRunner");
        pcGame.setPrice(900);
        given(pcGameService.createPcGame(pcGame)).willReturn(new ResponseEntity<>(pcGame, HttpStatus.CREATED));
        pcGameService.createPcGame(pcGame);

        verify(gameRepository).save(pcGame);
    }
}
