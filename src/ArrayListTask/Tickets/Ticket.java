package ArrayListTask.Tickets;

public abstract class Ticket {

    private final int _price; // Der Preis
    private boolean _validated; // Ungültig, wenn entwertet!
    private final String _owner;

    public Ticket(String owner, int price) {
        this._price = price;
        this._owner = owner;
        this._validated = false;
    }

    public String get_owner() { return _owner; }
    public int get_price() { return _price; }

    public void entwerten() { _validated = true; }
    public boolean istEntwertet() { return _validated; }
    public abstract boolean gueltigInZone(int zone);
}
