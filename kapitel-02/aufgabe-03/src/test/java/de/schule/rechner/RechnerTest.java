package de.schule.rechner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RechnerTest {

    @Test
    void addiereZweiZahlen() {
        assertEquals(7, Rechner.rechne(new String[]{"add", "3", "4"}));
    }

    @Test
    void subtrahiereZweiZahlen() {
        assertEquals(6, Rechner.rechne(new String[]{"sub", "10", "4"}));
    }

    @Test
    void multipliziereZweiZahlen() {
        assertEquals(20, Rechner.rechne(new String[]{"mul", "5", "4"}));
    }

    @Test
    void dividiereZweiZahlen() {
        assertEquals(3, Rechner.rechne(new String[]{"div", "12", "4"}));
    }

    @Test
    void rechneMitNegativenZahlen() {
        assertEquals(-5, Rechner.rechne(new String[]{"add", "-8", "3"}));
    }

    @Test
    void fehlerBeiFalscherArgumentAnzahl() {
        assertThrows(IllegalArgumentException.class,
                () -> Rechner.rechne(new String[]{"add", "3"}));
    }

    @Test
    void fehlerBeiUnbekannterOperation() {
        assertThrows(IllegalArgumentException.class,
                () -> Rechner.rechne(new String[]{"pow", "2", "3"}));
    }

    @Test
    void fehlerBeiDivisionDurchNull() {
        assertThrows(IllegalArgumentException.class,
                () -> Rechner.rechne(new String[]{"div", "5", "0"}));
    }

    @Test
    void fehlerBeiUngueltigerZahl() {
        assertThrows(IllegalArgumentException.class,
                () -> Rechner.rechne(new String[]{"add", "drei", "4"}));
    }
}
