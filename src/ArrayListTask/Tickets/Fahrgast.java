package ArrayListTask.Tickets;

public class Fahrgast extends Person {
    private Ticket _ticket;
    private double _money;

    public Fahrgast(String name, Ticket ticket)
    {
        super(name);
        set_ticket(ticket);
    }

    public Ticket get_ticket() { return _ticket; }
    public void set_ticket(Ticket _ticket) { this._ticket = _ticket; }
    public double get_money() { return _money; }
    public void set_money(double _money) { this._money = _money; }

    public void purchaseTicket()
    {

    }

    @Override
    public String toString()
    {
        return "I'm Fahrgast with " + get_money() + " moneys and Ticket: " + get_ticket();
    }

}
