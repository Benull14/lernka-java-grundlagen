package de.lernplattform.datentypen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MesswertTest {

    private final Messwert messwert = new Messwert();

    @Test
    void nullPasstInByte() {
        assertTrue(messwert.passtInByte(0));
    }

    @Test
    void untereGrenzePasstInByte() {
        assertTrue(messwert.passtInByte(-128));
    }

    @Test
    void obereGrenzePasstInByte() {
        assertTrue(messwert.passtInByte(127));
    }

    @Test
    void positiverWertImBereichPasst() {
        assertTrue(messwert.passtInByte(42));
    }

    @Test
    void negativerWertImBereichPasst() {
        assertTrue(messwert.passtInByte(-100));
    }

    @Test
    void einsUeberObererGrenzePasstNicht() {
        assertFalse(messwert.passtInByte(128));
    }

    @Test
    void einsUnterUntererGrenzePasstNicht() {
        assertFalse(messwert.passtInByte(-129));
    }

    @Test
    void grosserPositiverWertPasstNicht() {
        assertFalse(messwert.passtInByte(1000));
    }

    @Test
    void grosserNegativerWertPasstNicht() {
        assertFalse(messwert.passtInByte(-5000));
    }
}
