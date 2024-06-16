package org.example;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LibraryImpl implements Library {
    @Override
    public int calculateWordsNumber(String text) {
        return 0;
    }

    @Override
    public boolean stringIsEmpty(String text) {
        return false;
    }

    @Override
    public double calculateAverageWordsNumberPerString(String text) {
        return 0;
    }

    @Override
    public Map<String, Long> calculateWordstoMap(String text) {
        return Arrays.stream(text.split("\\s"))
                .filter(s -> !s.matches("\\d"))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }
}
