package ArrayListTask.Tickets;

public class Mehrfachticket extends Ticket {
    private int _zone;
    private final int _maxRides = 10;

    public Mehrfachticket(int preis, int zone) {
        super(preis);
        set_zone(zone);
    }

    public int get_zone() { return _zone; }
    public void set_zone(int _zone) { this._zone = _zone; }

    @Override
    public boolean gueltigInZone(int zone) {
        return get_zone() == zone;
    }

    @Override
    public void entwerten()
    {

    }
}
