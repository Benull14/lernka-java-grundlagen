package de.lernka;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests fuer die Eingabeverarbeitung mit Scanner.
 */
class BegruessungTest {

    private Scanner scannerAus(String eingabe) {
        return new Scanner(eingabe);
    }

    @Test
    void begruessungMitNameUndAlter() {
        Begruessung b = new Begruessung();
        Scanner sc = scannerAus("Anna\n25\n");
        assertEquals("Hallo Anna, du bist 25 Jahre alt.", b.verarbeiteEingabe(sc));
    }

    @Test
    void begruessungMitAnderemNamen() {
        Begruessung b = new Begruessung();
        Scanner sc = scannerAus("Tom\n40\n");
        assertEquals("Hallo Tom, du bist 40 Jahre alt.", b.verarbeiteEingabe(sc));
    }

    @Test
    void begruessungMitAlterNull() {
        Begruessung b = new Begruessung();
        Scanner sc = scannerAus("Baby\n0\n");
        assertEquals("Hallo Baby, du bist 0 Jahre alt.", b.verarbeiteEingabe(sc));
    }

    @Test
    void begruessungMitLeerzeichenImName() {
        Begruessung b = new Begruessung();
        Scanner sc = scannerAus("Max Mustermann\n33\n");
        assertEquals("Hallo Max Mustermann, du bist 33 Jahre alt.", b.verarbeiteEingabe(sc));
    }
}
