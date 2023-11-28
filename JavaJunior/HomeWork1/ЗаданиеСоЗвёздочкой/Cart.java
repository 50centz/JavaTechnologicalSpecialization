package ru.geekbrains.lesson1.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart <T extends Food>{

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    public Cart(Class<T> clazz, UMarket market)
    {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs(){
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }

    /**
     * Балансировка корзины
     */
    public void cardBalancing()
    {
        /*boolean proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;*/

        boolean[] array = {false, false, false};

        foodstuffs.forEach(food -> {
            if (!array[0] && food.getProteins())
                array[0] = true;
            else if (!array[1] && food.getFats())
                array[1] = true;
            else if (!array[2] && food.getCarbohydrates())
                array[2] = true;
            if (array[0] && array[1] && array[2])
                return;
        });

        /*for (var food : foodstuffs)
        {
            if (!proteins && food.getProteins())
                proteins = true;
            else
            if (!fats && food.getFats())
                fats = true;
            else
            if (!carbohydrates && food.getCarbohydrates())
                carbohydrates = true;
            if (proteins && fats && carbohydrates)
                break;
        }*/

        if (array[0] && array[1] && array[2])
        {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        market.getThings(Food.class).forEach(thing -> {
            if (!array[0] && thing.getProteins())
            {
                array[0] = true;
                foodstuffs.add((T)thing);
            }
            else if (!array[1] && thing.getFats())
            {
                array[1] = true;
                foodstuffs.add((T)thing);
            }
            else if (!array[2] && thing.getCarbohydrates())
            {
                array[2] = true;
                foodstuffs.add((T)thing);
            }
            if (array[0] && array[1] && array[2])
                return;
        });

        /*for (var thing : market.getThings(Food.class))
        {
            if (!array[0] && thing.getProteins())
            {
                array[0] = true;
                foodstuffs.add((T)thing);
            }
            else if (!array[1] && thing.getFats())
            {
                array[1] = true;
                foodstuffs.add((T)thing);
            }
            else if (!array[2] && thing.getCarbohydrates())
            {
                array[2] = true;
                foodstuffs.add((T)thing);
            }
            if (array[0] && array[1] && array[2])
                break;
        }*/

        if (array[0] && array[1] && array[2])
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

    }

}
