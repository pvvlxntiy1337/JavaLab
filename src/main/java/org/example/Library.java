package org.example;

import java.util.Map;
interface Library {

    int calculateWordsNumber(String text);

    boolean stringIsEmpty(String text);
    double calculateAverageWordsNumberPerString(String text);
    Map<String, Long> calculateWordstoMap(String text);
}
