package ru.geekbrains.homework9db;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.geekbrains.homework9db.models.PcGame;
import ru.geekbrains.homework9db.repository.GameRepository;
import ru.geekbrains.homework9db.services.PcGameService;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class Homework9dbApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Mock
	private GameRepository gameRepository;

	@InjectMocks
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
