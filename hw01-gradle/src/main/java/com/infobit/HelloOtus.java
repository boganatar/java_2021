package com.infobit;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

/**
 * @author Andriy
 */
public class HelloOtus {
    public static void main(String[] args) {
        Map items = ImmutableMap.of("Frodo", 3, "Sam", 4, "Gandalf", 1);

        items.entrySet().stream().forEach(System.out::println);
    }
}
