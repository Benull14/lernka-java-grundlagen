package de.lernplattform.datentypen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SensorbezeichnungTest {

    private final Sensorbezeichnung sensor = new Sensorbezeichnung();

    @Test
    @DisplayName("null liefert 0")
    void nullLiefertNull() {
        assertEquals(0, sensor.laengeDerBezeichnung(null));
    }

    @Test
    @DisplayName("leerer String liefert 0")
    void leererStringLiefertNull() {
        assertEquals(0, sensor.laengeDerBezeichnung(""));
    }

    @Test
    @DisplayName("normale Bezeichnung liefert korrekte Laenge")
    void normaleBezeichnung() {
        assertEquals(6, sensor.laengeDerBezeichnung("Sensor"));
    }

    @Test
    @DisplayName("Bezeichnung mit Leerzeichen wird vollstaendig gezaehlt")
    void bezeichnungMitLeerzeichen() {
        assertEquals(11, sensor.laengeDerBezeichnung("Temp Sensor"));
    }

    @Test
    @DisplayName("einzelnes Zeichen liefert 1")
    void einzelnesZeichen() {
        assertEquals(1, sensor.laengeDerBezeichnung("A"));
    }
}
