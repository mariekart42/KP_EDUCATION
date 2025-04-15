package ArrayListTask.Tickets;

import java.time.LocalTime;

public class Einzelticket extends Ticket {
    private int _zone;
    private LocalTime _validUntil;

    public Einzelticket(int preis, int zone) {
        super(preis);
        set_zone(zone);
    }

    public int get_zone() { return _zone; }
    public void set_zone(int _zone) { this._zone = _zone; }
    public LocalTime get_validUntil() { return _validUntil; }
    public void set_validUntil(LocalTime _validUntil) { this._validUntil = _validUntil; }

    @Override
    public boolean gueltigInZone(int zone) {
        return get_zone() == zone;
    }

    @Override
    public String toString()
    {
        return "\nEinzelticket valid in Zone: " + get_zone();
    }
}
