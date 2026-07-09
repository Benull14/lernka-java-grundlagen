package de.lernplattform.datentypen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MesswertTest {

    @Test
    void temperaturLiegtImBereich() {
        Messwert m = new Messwert(22.5, 100, 'A');
        assertTrue(m.istTemperaturImBereich(-20.0, 120.0));
    }

    @Test
    void temperaturAusserhalbBereich() {
        Messwert m = new Messwert(150.0, 100, 'A');
        assertFalse(m.istTemperaturImBereich(-20.0, 120.0));
    }

    @Test
    void temperaturWirdKorrektGerundet() {
        Messwert m = new Messwert(22.6, 0, 'B');
        assertEquals(23, m.temperaturGerundet());
    }

    @Test
    void zaehlerstandWirdGeboxt() {
        Messwert m = new Messwert(0.0, 42, 'C');
        Integer boxed = m.zaehlerstandAlsWrapper();
        assertEquals(Integer.valueOf(42), boxed);
    }

    @Test
    void zaehlerstandOderStandardNimmtStandardBeiNull() {
        assertEquals(-1, Messwert.zaehlerstandOderStandard(null, -1));
    }

    @Test
    void zaehlerstandOderStandardNimmtWert() {
        assertEquals(7, Messwert.zaehlerstandOderStandard(7, -1));
    }

    @Test
    void kennungAlsTextLiefertZeichen() {
        Messwert m = new Messwert(0.0, 0, 'X');
        assertEquals("X", m.kennungAlsText());
    }

    @Test
    void kennungAlsTextBehandeltNullzeichen() {
        Messwert m = new Messwert(0.0, 0, '\u0000');
        assertEquals("unbekannt", m.kennungAlsText());
    }
}
