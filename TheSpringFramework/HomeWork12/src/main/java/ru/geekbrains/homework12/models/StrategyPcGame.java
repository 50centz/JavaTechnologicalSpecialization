package ru.geekbrains.homework12.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.geekbrains.homework12.enums.TypePcGame;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StrategyPcGame extends PcGame{


    private Long Id;
    private TypePcGame typePcGame;

    public StrategyPcGame(String title, int price, TypePcGame typePcGame){
        super(title, price);
        this.typePcGame = typePcGame;
    }

}
