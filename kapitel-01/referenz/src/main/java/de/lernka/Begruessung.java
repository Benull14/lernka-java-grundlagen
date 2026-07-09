package de.lernka;

import java.util.Scanner;

/**
 * Konsolenprogramm 'Begruessung'.
 *
 * <p>Dieses Referenzprogramm liest ueber die Tastatur einen Namen und ein
 * Alter ein und gibt anschliessend eine formatierte Begruessung auf der
 * Konsole aus. Es dient als Vorbild fuer:</p>
 * <ul>
 *   <li>den grundlegenden Aufbau einer Klasse mit main-Methode,</li>
 *   <li>die Eingabe mit {@link java.util.Scanner},</li>
 *   <li>die Ausgabe mit {@code System.out.println},</li>
 *   <li>Kommentare und Java-Namenskonventionen.</li>
 * </ul>
 */
public class Begruessung {

    /**
     * Einstiegspunkt des Programms.
     *
     * @param args Kommandozeilenargumente (werden hier nicht verwendet)
     */
    public static void main(String[] args) {
        // Scanner zum Einlesen von der Standardeingabe (Tastatur).
        // try-with-resources sorgt dafuer, dass der Scanner am Ende
        // automatisch geschlossen wird.
        try (Scanner scanner = new Scanner(System.in)) {

            // Namen einlesen (eine komplette Zeile).
            System.out.print("Bitte geben Sie Ihren Namen ein: ");
            String name = scanner.nextLine();

            // Alter einlesen und in eine ganze Zahl umwandeln.
            System.out.print("Bitte geben Sie Ihr Alter ein: ");
            int alter = Integer.parseInt(scanner.nextLine().trim());

            // Begruessungstext erzeugen und ausgeben.
            String begruessung = erstelleBegruessung(name, alter);
            System.out.println(begruessung);
        }
    }

    /**
     * Erstellt aus Name und Alter einen formatierten Begruessungstext.
     *
     * @param name  der einzusetzende Name
     * @param alter das einzusetzende Alter in Jahren
     * @return der zusammengesetzte Begruessungstext
     */
    public static String erstelleBegruessung(String name, int alter) {
        // Mit String.format werden die Platzhalter durch die Werte ersetzt.
        return String.format(
                "Hallo %s, willkommen! Sie sind %d Jahre alt.",
                name, alter);
    }
}
