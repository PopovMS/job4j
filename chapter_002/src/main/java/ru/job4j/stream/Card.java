package ru.job4j.stream;

import java.util.stream.Stream;

/**
 * Клас генерирует из классов перечислений поток, для генерации колоды карт
 */

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(card -> Stream.of(Value.values())
                    .map(val -> card + " " + val))
                .forEach(System.out::println);

    }

}
