package com.infobit;

import java.util.Map;

/**
 * @author Andriy
 */
public class HelloOtus {
    public static void main(String[] args) {
        Map<String, Integer> items = Map.of("Frodo", 3, "Sam", 4, "Gandalf", 1);

        items.entrySet().forEach(System.out::println);
    }
}
