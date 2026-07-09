package de.lernplattform.datentypen;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ZaehlerTest {

    private final Zaehler zaehler = new Zaehler();

    @Test
    void kleineWerteVerursachenKeinenUeberlauf() {
        assertFalse(zaehler.verursachtUeberlauf(1, 1));
    }

    @Test
    void nullPlusNullIstKeinUeberlauf() {
        assertFalse(zaehler.verursachtUeberlauf(0, 0));
    }

    @Test
    void maxWertPlusEinsVerursachtUeberlauf() {
        assertTrue(zaehler.verursachtUeberlauf(Integer.MAX_VALUE, 1));
    }

    @Test
    void maxWertPlusNullIstKeinUeberlauf() {
        assertFalse(zaehler.verursachtUeberlauf(Integer.MAX_VALUE, 0));
    }

    @Test
    void zweiGrosseWerteVerursachenUeberlauf() {
        assertTrue(zaehler.verursachtUeberlauf(2_000_000_000, 2_000_000_000));
    }

    @Test
    void minWertPlusMinusEinsVerursachtUnterlauf() {
        assertTrue(zaehler.verursachtUeberlauf(Integer.MIN_VALUE, -1));
    }

    @Test
    void minWertPlusNullIstKeinUeberlauf() {
        assertFalse(zaehler.verursachtUeberlauf(Integer.MIN_VALUE, 0));
    }

    @Test
    void zweiGrosseNegativeWerteVerursachenUnterlauf() {
        assertTrue(zaehler.verursachtUeberlauf(-2_000_000_000, -2_000_000_000));
    }

    @Test
    void positivUndNegativGleichenSichAusKeinUeberlauf() {
        assertFalse(zaehler.verursachtUeberlauf(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    @Test
    void maxWertGenauNochGueltig() {
        assertFalse(zaehler.verursachtUeberlauf(Integer.MAX_VALUE - 1, 1));
    }
}
