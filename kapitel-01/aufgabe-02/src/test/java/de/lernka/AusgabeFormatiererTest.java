package de.lernka;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests fuer die Textverkettung von Name und Alter.
 */
class AusgabeFormatiererTest {

    private final AusgabeFormatierer formatierer = new AusgabeFormatierer();

    @Test
    void formatiertNamenUndAlter() {
        assertEquals("Anna ist 25 Jahre alt.", formatierer.formatiere("Anna", 25));
    }

    @Test
    void formatiertAnderenNamenUndAlter() {
        assertEquals("Ben ist 40 Jahre alt.", formatierer.formatiere("Ben", 40));
    }

    @Test
    void formatiertAlterNull() {
        assertEquals("Baby ist 0 Jahre alt.", formatierer.formatiere("Baby", 0));
    }

    @Test
    void formatiertLeerenNamen() {
        assertEquals(" ist 10 Jahre alt.", formatierer.formatiere("", 10));
    }
}
