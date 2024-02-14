package ru.geekbrains.homework9pages.service;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.homework9pages.models.Game;


import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ServiceApi {


    private RestTemplate restTemplate;

//    private HttpHeaders headers;

    //@Value("${url.api}")
    private static final String urlApi = "http://192.168.22.69:8081/api/PcGame";

    public List<Game> getAllPcGame(){
        return List.of(Objects.requireNonNull(restTemplate.getForObject(urlApi + "/allPcGame", Game[].class)));
    }

    public void createPcGame(Game game){
        Game game1 = restTemplate.postForObject(urlApi + "/add", game, Game.class);
    }

    public void updatePcGameById(Game game){
        restTemplate.put(urlApi + "/update", game);
    }

    public void deleteById(Game game){
        restTemplate.put(urlApi + "/delete", game);
    }
}
