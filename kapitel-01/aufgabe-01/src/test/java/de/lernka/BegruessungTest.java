package de.lernka;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Testet die Methode begruessung().
 */
class BegruessungTest {

    @Test
    void begruessungLiefertNichtNull() {
        Begruessung b = new Begruessung();
        assertNotNull(b.begruessung(), "Die Methode darf nicht null zurueckgeben.");
    }

    @Test
    void begruessungLiefertErwartetenText() {
        Begruessung b = new Begruessung();
        assertEquals("Hallo und herzlich willkommen!", b.begruessung());
    }
}
