package ru.geekbrains.homework9pages.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {

    private Long id;
    private String title;
    private int price;
}
