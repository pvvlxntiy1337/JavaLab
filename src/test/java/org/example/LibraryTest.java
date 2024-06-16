package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    Library library;

    public static final String shortString= "This is some text of the words";
    public static final String longString= """
    This is some text of the words
    This is some text of the words
    This is some text of the words
    This is some text of the words
    This is some text of the words
    """;
    public static final String longStringWithDigits= """
    This is some text of the words 2
    This is some text of the words 3
    This is some text of the words 4
    This is some text of the words 5
    This is some text of the words 6
    """;

    @BeforeEach
    void setUp() {
        library = new LibraryImpl();
    }

    @AfterEach
    void tearDown() {
        library = null;
    }

    @Test
    void ExpectCorrectNumberOfWordsForSingleString() {
        int exptected = 7;
        int actual = library.calculateWordsNumber(shortString);
        assertEquals(exptected, actual);
        assertNotEquals(0, actual);
    }
    @Test
    void ExpectCorrectNumberOfWordsForMultilineString() {
        int exptected = 35;
        int actual = library.calculateWordsNumber(longString);
        assertEquals(exptected, actual);
        assertNotEquals(0, actual);
    }

    @Test
    void ExpectCorrectPairOfWordsForMultilineString() {
        Map<String, Long> expectedPairs = Map.of(
        "This", 1L,
        "is", 1L,
        "some", 1L,
        "text", 1L,
        "of", 1L,
        "the", 1L,
        "words",1L);
        int exptectedCount = expectedPairs.size();
        var actual = library.calculateWordstoMap(longString);
        assertEquals(expectedPairs, actual);
        assertEquals(exptectedCount, actual.size());
    }
    @Test
    void ExpectNotNullPairOfWordsForMultilineString() {
        assertNotNull(library.calculateWordstoMap(longString));
    }

    @Test
    void stringIsEmpty() {
    }

    @Test
    void calculateAverageWordsNumberPerString() {
    }

    @Test
    void ExpectCorrectAverageNumberOfWordsForMultilineString() {
        double exptected = 7.0;
        double actual = library.calculateAverageWordsNumberPerString(longString);
        assertEquals(exptected, actual, 0.1);
        assertNotEquals(0, actual, 0.1);
    }
}