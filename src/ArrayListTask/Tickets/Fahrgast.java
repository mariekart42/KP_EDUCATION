package ArrayListTask.Tickets;

public class Fahrgast extends Person {
    private final Ticket _ticket;
    private double _money;

    public Fahrgast(String name, Ticket ticket)
    {
        super(name);
        this._ticket = ticket;
        set_money(0);
    }

    public Ticket get_ticket() { return _ticket; }
    public double get_money() { return _money; }
    public void set_money(double _money) { this._money = _money; }

    @Override
    public String toString()
    {
        return "I'm Fahrgast with " + get_money() + " moneys and Ticket: " + get_ticket();
    }
}
