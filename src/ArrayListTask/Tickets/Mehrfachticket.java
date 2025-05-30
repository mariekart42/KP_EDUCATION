package ArrayListTask.Tickets;

public class Mehrfachticket extends Ticket {
    private final int _zone;
    private int _ridesLeft;

    public Mehrfachticket(String owner, int preis, int zone, int rides)
    {
        super(owner, preis);
        this._zone = zone;
        this._ridesLeft = rides;
    }

    public int get_zone() { return _zone; }
    public int get_ridesLeft() { return _ridesLeft; }
    public void set_ridesLeft(int _ridesLeft) { this._ridesLeft = _ridesLeft; }


    @Override
    public boolean gueltigInZone(int zone)
    {
        return get_zone() == zone;
    }

    @Override
    public void entwerten()
    {
        set_ridesLeft(get_ridesLeft() - 1);
    }


    @Override
    public String toString()
    {
        return "\nMehrfachticket valid in Zone: " + get_zone() + " and has " + get_ridesLeft() + " rides left";
    }
}
