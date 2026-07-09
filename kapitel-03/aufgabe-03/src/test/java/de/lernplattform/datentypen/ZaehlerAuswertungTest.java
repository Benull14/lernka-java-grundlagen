package de.lernplattform.datentypen;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZaehlerAuswertungTest {

    private final ZaehlerAuswertung auswertung = new ZaehlerAuswertung();

    @Test
    void summiertMehrereMesswerte() {
        List<Integer> werte = Arrays.asList(10, 20, 30);
        assertEquals(60, auswertung.summiereMesswerte(werte));
    }

    @Test
    void summiertEinzelnenWert() {
        List<Integer> werte = Collections.singletonList(42);
        assertEquals(42, auswertung.summiereMesswerte(werte));
    }

    @Test
    void summiertLeereListeZuNull() {
        List<Integer> werte = new ArrayList<>();
        assertEquals(0, auswertung.summiereMesswerte(werte));
    }

    @Test
    void summiertNegativeUndPositiveWerte() {
        List<Integer> werte = Arrays.asList(-5, 10, -3, 8);
        assertEquals(10, auswertung.summiereMesswerte(werte));
    }

    @Test
    void gibtPrimitivenIntZurueck() {
        List<Integer> werte = Arrays.asList(1, 2, 3, 4, 5);
        int ergebnis = auswertung.summiereMesswerte(werte);
        assertEquals(15, ergebnis);
    }
}
