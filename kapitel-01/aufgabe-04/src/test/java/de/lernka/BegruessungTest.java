package de.lernka;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Testet die Methode erstelleBegruessung der Klasse Begruessung.
 */
class BegruessungTest {

    @Test
    void erwachsenerWirdMitSieBegruesst() {
        Begruessung begruessung = new Begruessung();
        String ergebnis = begruessung.erstelleBegruessung("Anna", 30);
        assertEquals("Guten Tag, Anna! Sie sind 30 Jahre alt.", ergebnis);
    }

    @Test
    void volljaehrigAbAchtzehnMitSie() {
        Begruessung begruessung = new Begruessung();
        String ergebnis = begruessung.erstelleBegruessung("Ben", 18);
        assertEquals("Guten Tag, Ben! Sie sind 18 Jahre alt.", ergebnis);
    }

    @Test
    void minderjaehrigWirdGeduzt() {
        Begruessung begruessung = new Begruessung();
        String ergebnis = begruessung.erstelleBegruessung("Clara", 17);
        assertEquals("Hallo, Clara! Du bist 17 Jahre alt.", ergebnis);
    }

    @Test
    void kindWirdGeduzt() {
        Begruessung begruessung = new Begruessung();
        String ergebnis = begruessung.erstelleBegruessung("David", 8);
        assertEquals("Hallo, David! Du bist 8 Jahre alt.", ergebnis);
    }
}
