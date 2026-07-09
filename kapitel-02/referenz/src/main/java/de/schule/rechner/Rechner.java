package de.schule.rechner;

/**
 * Referenzbeispiel zum Kapitel "Lebenszyklus eines Java-Programms".
 *
 * <p>Dieses Programm zeigt, wie aus Quellcode ein laufendes Programm wird und
 * wie Programmargumente (die Parameter der main-Methode) verarbeitet werden.</p>
 *
 * <h2>Vom Quellcode zum laufenden Programm</h2>
 * <ol>
 *   <li><b>Schreiben:</b> Der Quellcode liegt in Rechner.java.</li>
 *   <li><b>Kompilieren:</b> Der Compiler uebersetzt den Quellcode in Bytecode.
 *       <pre>javac -d target/classes src/main/java/de/schule/rechner/Rechner.java</pre>
 *       Es entsteht die Datei Rechner.class (Bytecode).</li>
 *   <li><b>Ausfuehren:</b> Die JVM startet den Bytecode und ruft die main-Methode auf.
 *       <pre>java -cp target/classes de.schule.rechner.Rechner 3 + 4</pre></li>
 * </ol>
 *
 * <p>Mit Maven laesst sich derselbe Ablauf automatisieren:</p>
 * <pre>
 * mvn package
 * java -cp target/classes de.schule.rechner.Rechner 3 + 4
 * </pre>
 *
 * <h2>Was sind Programmargumente?</h2>
 * <p>Beim Aufruf <code>java ... Rechner 3 + 4</code> landen die drei Werte
 * "3", "+" und "4" im Array <code>args</code> der main-Methode:
 * args[0]="3", args[1]="+", args[2]="4".</p>
 */
public class Rechner {

    /**
     * Einstiegspunkt des Programms. Die JVM ruft diese Methode beim Start auf
     * und uebergibt die Programmargumente im Array {@code args}.
     *
     * @param args die beim Programmstart uebergebenen Argumente,
     *             erwartet: zahl1 operator zahl2 (z.B. 3 + 4)
     */
    public static void main(String[] args) {
        if (!hatGenugArgumente(args)) {
            System.out.println("Verwendung: java de.schule.rechner.Rechner <zahl1> <operator> <zahl2>");
            System.out.println("Beispiel  : java de.schule.rechner.Rechner 3 + 4");
            return;
        }

        double zahl1 = leseZahl(args[0]);
        String operator = args[1];
        double zahl2 = leseZahl(args[2]);

        double ergebnis = berechne(zahl1, operator, zahl2);
        System.out.println(zahl1 + " " + operator + " " + zahl2 + " = " + ergebnis);
    }

    /**
     * Prueft, ob genug Argumente uebergeben wurden.
     *
     * @param args die Programmargumente
     * @return true, wenn mindestens drei Argumente vorhanden sind
     */
    static boolean hatGenugArgumente(String[] args) {
        return args != null && args.length >= 3;
    }

    /**
     * Wandelt ein Argument (Text) in eine Zahl um.
     *
     * @param argument der Text, der eine Zahl darstellen soll
     * @return die umgewandelte Zahl
     * @throws IllegalArgumentException wenn der Text keine gueltige Zahl ist
     */
    static double leseZahl(String argument) {
        try {
            return Double.parseDouble(argument);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Keine gueltige Zahl: " + argument);
        }
    }

    /**
     * Fuehrt die gewuenschte Rechenoperation aus.
     *
     * @param zahl1    die erste Zahl
     * @param operator einer von +, -, *, /
     * @param zahl2    die zweite Zahl
     * @return das Ergebnis der Rechnung
     * @throws IllegalArgumentException bei unbekanntem Operator oder Division durch 0
     */
    static double berechne(double zahl1, String operator, double zahl2) {
        switch (operator) {
            case "+":
                return zahl1 + zahl2;
            case "-":
                return zahl1 - zahl2;
            case "*":
                return zahl1 * zahl2;
            case "/":
                if (zahl2 == 0) {
                    throw new IllegalArgumentException("Division durch 0 ist nicht erlaubt.");
                }
                return zahl1 / zahl2;
            default:
                throw new IllegalArgumentException("Unbekannter Operator: " + operator);
        }
    }
}
