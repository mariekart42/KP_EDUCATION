package ArrayListTask.Tickets;

public class Mehrfachticket extends Ticket {
    private int _zone;
    private int _ridesLeft = 10;

    public Mehrfachticket(String owner, int preis, int zone) {
        super(owner, preis);
        set_zone(zone);
    }

    public int get_zone() { return _zone; }
    public void set_zone(int _zone) { this._zone = _zone; }
    public int get_ridesLeft() { return _ridesLeft; }
    public void set_ridesLeft(int _ridesLeft) { this._ridesLeft = _ridesLeft; }

    @Override
    public boolean gueltigInZone(int zone) {
        return get_zone() == zone;
    }

    @Override
    public void entwerten()
    {

    }

    @Override
    public String toString()
    {
        return "\nMehrfachticket valid in Zone: " + get_zone() + " and has " + get_ridesLeft() + " rides left";
    }
}
