package com.kalita_ivan.collections;

import java.util.HashMap;

public class WordsApplication {
    public static void main(String[] args) {
        String[] sourceArray = {
            "dog", "fox", "cat", "parrot", "fox",
            "tribe", "rabbit", "rabbit", "wolf",
            "frog", "monkey", "snake", "camel"
        };
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < sourceArray.length; i++) {
            String key = sourceArray[i];
            int occurrences = map.getOrDefault(key, 0);
            occurrences++;
            map.put(key, occurrences);
        }

        for(String key: map.keySet()) {
            System.out.format("%d – %s\n", map.get(key), key);
        }
    }
}
