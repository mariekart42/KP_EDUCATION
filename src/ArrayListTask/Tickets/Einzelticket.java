package ArrayListTask.Tickets;

public class Einzelticket extends Ticket {
    private int _zone;

    public Einzelticket(int preis, int zone) {
        super(preis);
        set_zone(zone);
    }

    public int get_zone() { return _zone; }
    public void set_zone(int _zone) { this._zone = _zone; }

    @Override
    public boolean gueltigInZone(int zone) {
        return get_zone() == zone;
    }


}
