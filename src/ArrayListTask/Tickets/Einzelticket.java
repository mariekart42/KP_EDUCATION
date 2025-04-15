package ArrayListTask.Tickets;

import java.time.LocalDateTime;

public class Einzelticket extends Ticket {
    private final int _zone;
    private final LocalDateTime _validUntil;

    public Einzelticket(String owner, int preis, int zone)
    {
        super(owner, preis);
        this._zone = zone;
        this._validUntil = LocalDateTime.now().plusHours(2);
    }

    public int get_zone() { return _zone; }
    public LocalDateTime get_validUntil() { return _validUntil; }

    @Override
    public boolean gueltigInZone(int zone)
    {
        return get_zone() == zone;
    }

    @Override
    public String toString()
    {
        return "\nEinzelticket for " + get_owner() + " valid in Zone: " + get_zone();
    }
}
