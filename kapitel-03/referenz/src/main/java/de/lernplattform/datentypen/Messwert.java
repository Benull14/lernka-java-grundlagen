package de.lernplattform.datentypen;

/**
 * Referenzbeispiel zum Kapitel "Datentypen".
 *
 * <p>Die Klasse {@code Messwert} nimmt Sensordaten unterschiedlicher primitiver
 * Typen auf und zeigt an einem zusammenhaengenden Beispiel:
 * <ul>
 *     <li>Verwendung primitiver Typen (double, int, char)</li>
 *     <li>Pruefen von Wertebereichen</li>
 *     <li>Umwandeln zwischen primitiven Typen und Wrapper-Klassen (Boxing/Unboxing)</li>
 *     <li>sichere Behandlung von {@code null}</li>
 * </ul>
 *
 * <p>Praxisbezug: Ein Sensor in der Produktionshalle liefert eine Temperatur
 * (Kommazahl), einen Zaehlerstand (ganze Zahl) und eine Kennung (einzelnes
 * Zeichen). Diese Werte muessen geprueft und weiterverarbeitet werden.
 *
 * <p>Dies ist Anschauungsmaterial, KEINE Aufgabe.
 */
public class Messwert {

    private final double temperatur;
    private final int zaehlerstand;
    private final char sensorkennung;

    public Messwert(double temperatur, int zaehlerstand, char sensorkennung) {
        this.temperatur = temperatur;
        this.zaehlerstand = zaehlerstand;
        this.sensorkennung = sensorkennung;
    }

    public double getTemperatur() {
        return temperatur;
    }

    public int getZaehlerstand() {
        return zaehlerstand;
    }

    public char getSensorkennung() {
        return sensorkennung;
    }

    /**
     * Prueft, ob die Temperatur im gueltigen Betriebsbereich liegt.
     * Beispiel: ein Sensor arbeitet zuverlaessig zwischen -20.0 und 120.0 Grad.
     */
    public boolean istTemperaturImBereich(double min, double max) {
        return temperatur >= min && temperatur <= max;
    }

    /**
     * Rundet die als double gespeicherte Temperatur auf einen int.
     * Zeigt eine explizite (verlustbehaftete) Umwandlung von double nach int.
     */
    public int temperaturGerundet() {
        return (int) Math.round(temperatur);
    }

    /**
     * Wandelt den primitiven Zaehlerstand in ein Wrapper-Objekt um (Boxing).
     * So kann der Wert z.B. in Collections abgelegt werden.
     */
    public Integer zaehlerstandAlsWrapper() {
        return Integer.valueOf(zaehlerstand);
    }

    /**
     * Liefert den Zaehlerstand aus einem Wrapper-Objekt zurueck (Unboxing).
     * Behandelt {@code null} sicher, indem ein Ersatzwert zurueckgegeben wird.
     */
    public static int zaehlerstandOderStandard(Integer wert, int standard) {
        if (wert == null) {
            return standard;
        }
        return wert; // automatisches Unboxing
    }

    /**
     * Gibt die Sensorkennung als String zurueck und behandelt dabei den
     * Sonderfall des Nullzeichens sicher.
     */
    public String kennungAlsText() {
        if (sensorkennung == '\u0000') {
            return "unbekannt";
        }
        return String.valueOf(sensorkennung);
    }

    @Override
    public String toString() {
        return "Messwert{temperatur=" + temperatur
                + ", zaehlerstand=" + zaehlerstand
                + ", sensorkennung=" + sensorkennung + "}";
    }
}
