package ArrayListTask.Tickets;

import java.time.LocalDateTime;

public abstract class Ticket {

    private final int _price; // Der Preis
    private final LocalDateTime _expirationDate;
    private boolean _validated; // Ungültig, wenn entwertet!

    public Ticket(int price) {
        this._price = price;
        this._expirationDate = LocalDateTime.now().plusMinutes(2);
        this._validated = false;
    }

    public LocalDateTime get_expirationDate() { return _expirationDate; }

    public int get_price() { return _price; }
    public void entwerten() { _validated = true; }
    public boolean istEntwertet() { return _validated; }
    public abstract boolean gueltigInZone(int zone);
}
