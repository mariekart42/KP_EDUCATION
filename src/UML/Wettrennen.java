package UML;

public class Wettrennen {
    public static void main(String[] args) {
        Fahrzeug fahrrad = new Fahrrad();
        Fahrzeug auto = new Auto();
        Fahrzeug rennwagen = new Rennwagen();
        Krankenwagen krankenwagen = new Krankenwagen();

        fahrrad.setzeGeschwindigkeit(20);
        auto.setzeGeschwindigkeit(150);
        rennwagen.setzeGeschwindigkeit(200);
        krankenwagen.setzeGeschwindigkeit(80);

        // Fahrrad 4 Stunden vorsprung (4 * 60 Minuten)
        fahrrad.bewege(240);

        auto.bewege(60);
        rennwagen.bewege(60);
        krankenwagen.bewege(60);

        System.out.println("\nEndpositionen:");
        System.out.println("Fahrrad: " + fahrrad.get_currentPos() + " km");
        System.out.println("Auto: " + auto.get_currentPos() + " km");
        System.out.println("Rennwagen: " + rennwagen.get_currentPos() + " km");
        System.out.println("Krankenwagen: " + krankenwagen.get_currentPos() + " km");
    }
}
