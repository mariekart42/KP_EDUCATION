package ArrayListTask.Tickets;

public class TarifbereichKontrolleur extends Person implements Kontrolleur {
    private int _invalidTicketsCount;

    public TarifbereichKontrolleur(String name)
    {
        super(name);
        set_invalidTicketsCount(0);
    }

    public int get_invalidTicketsCount() { return _invalidTicketsCount; }
    public void set_invalidTicketsCount(int _invalidTicketsCount) { this._invalidTicketsCount = _invalidTicketsCount; }


    @Override
    public void checkTicket(Person p) {
        if (p instanceof VBMitarbeiter || p instanceof TarifbereichKontrolleur)
            return;

        if (p instanceof Fahrgast)
        {
            Ticket ticket = ((Fahrgast) p).get_ticket();
            // ticket valid?
                // correct person


                // valid zone
                // not entwertet yet
                // not exceeded time
            // if invalid: set_invalidTicketsCount(get_invalidTicketsCount() + 1);
        }
        System.out.println("Kontrolliere: " + p);
    }

    @Override
    public int getAmountInvalidTickets() {
        return get_invalidTicketsCount();
    }
}
