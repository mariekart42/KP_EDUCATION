package moreUMLTasks;

public class Kreditkarte {
    private int geheimzahl;
    private String typ;
    private double verfuegungsrahmen = 2000.0;

    public Kreditkarte() {}

    public void geheimzahlAnzeigen() {
        System.out.println("Geheimzahl: " + geheimzahl);
    }

    public void verfuegungsrahmenAnzeigen() {
        System.out.println("Verfügungsrahmen: " + verfuegungsrahmen);
    }

    public int getGeheimzahl() { return geheimzahl; }
    public void setGeheimzahl(int geheimzahl) { this.geheimzahl = geheimzahl; }
    public String getTyp() { return typ; }
    public void setTyp(String typ) { this.typ = typ; }
    public double getVerfuegungsrahmen() { return verfuegungsrahmen; }
    public void setVerfuegungsrahmen(double verfuegungsrahmen) { this.verfuegungsrahmen = verfuegungsrahmen; }
}


