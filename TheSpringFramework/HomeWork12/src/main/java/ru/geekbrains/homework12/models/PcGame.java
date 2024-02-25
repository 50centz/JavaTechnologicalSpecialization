package ru.geekbrains.homework12.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcGame {

    private String title;
    private int price;
}
