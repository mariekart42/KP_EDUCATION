package ArrayListTask.Tickets;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TarifbereichKontrolleur extends Person implements Kontrolleur {
    private int _invalidTicketsCount;
    private int _zoneToControl;

    public TarifbereichKontrolleur(String name, int zoneToControl)
    {
        super(name);
        set_invalidTicketsCount(0);
        set_zoneToControl(zoneToControl);
    }

    public int get_invalidTicketsCount() { return _invalidTicketsCount; }
    public void set_invalidTicketsCount(int _invalidTicketsCount) { this._invalidTicketsCount = _invalidTicketsCount; }
    public int get_zoneToControl() { return _zoneToControl; }
    public void set_zoneToControl(int _zoneToControl) { this._zoneToControl = _zoneToControl; }


    public static final String RESET = "\033[0m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    @Override
    public void checkTicket(Person person)
    {
        if (person instanceof Fahrgast fahrgast)
        {
            Ticket ticket = fahrgast.get_ticket();
            if (!ticketIsValid(person, ticket))
                set_invalidTicketsCount(get_invalidTicketsCount() + 1);
            ticket.entwerten();
        }
        else if (person instanceof TarifbereichKontrolleur)
            System.out.println(GREEN + "✅ Kontrolleur doesn't need a ticket" + RESET);
        else if (person instanceof VBMitarbeiter)
            System.out.println(GREEN + "✅ VB Mitarbeiter doesn't need a ticket" + RESET);

    }

    private boolean ticketIsValid(Person person, Ticket ticket)
    {
        if (!person.get_name().equals(ticket.get_owner())) {
            System.out.println(RED + "❌ Error: Ticket does not belong to this person." + RESET);
            return false;
        }

        if (!ticket.gueltigInZone(get_zoneToControl())) {
            System.out.println(RED + "❌ Error: Ticket not valid in this zone." + RESET);
            return false;
        }

        if (ticket instanceof Einzelticket einzelticket) {
            if (einzelticket.istEntwertet()) {
                System.out.println(YELLOW + "⚠️  Warning: Ticket was already used." + RESET);
                return false;
            }
            if (einzelticket.get_validUntil().isBefore(LocalDateTime.now())) {
                System.out.println(RED + "❌ Error: Ticket expired." + RESET);
                return false;
            }
        } else if (ticket instanceof Mehrfachticket mehrfachticket) {
            if (mehrfachticket.get_ridesLeft() <= 0) {
                System.out.println(RED + "❌ Error: No rides left on this ticket." + RESET);
                return false;
            }
        } else if (ticket instanceof Jahresabo jahresabo) {
            if (jahresabo.get_validUntil().isBefore(LocalDate.now())) {
                System.out.println(RED + "❌ Error: Jahresabo expired." + RESET);
                return false;
            }
        }

        System.out.println(GREEN + "✅ Ticket is valid." + RESET);
        return true;
    }

    @Override
    public int getAmountInvalidTickets() {
        return get_invalidTicketsCount();
    }

    @Override
    public String toString()
    {
        return "I'm Tarifbereich Kontrolleur " + get_name() + "\nI found " + get_invalidTicketsCount() + " invalid Tickets";
    }
}
