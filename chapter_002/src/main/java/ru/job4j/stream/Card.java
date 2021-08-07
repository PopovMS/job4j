package ru.job4j.stream;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
        ArrayList<Card> cards = new ArrayList<>();
        Stream.of(Suit.values())
                .flatMap((card -> Stream.of(Value.values())
                    .map(val -> new Card(card, val))))
                .forEach(rsl -> System.out.println(rsl.suit + " " + rsl.value));
    }

}
