package ArrayListTask.Tickets;

public abstract class Ticket {

    private int _preis; // Der Preis
    private boolean _entwertet; // Ungültig, wenn entwertet!

    public Ticket(int preis) {
        this._preis = preis;
        _entwertet = false;
    }

    public int get_preis() { return _preis; }
    public void entwerten() { _entwertet = true; }
    public boolean istEntwertet() { return _entwertet; }
    public abstract boolean gueltigInZone(int zone);
}
