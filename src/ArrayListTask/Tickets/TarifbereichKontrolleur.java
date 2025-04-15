package ArrayListTask.Tickets;

import Helper.ConsoleColors;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TarifbereichKontrolleur extends Person implements Kontrolleur {
    private int _invalidTicketsCount;
    private final int _zoneToControl;

    public TarifbereichKontrolleur(String name, int zoneToControl)
    {
        super(name);
        set_invalidTicketsCount(0);
        this._zoneToControl = zoneToControl;
    }

    public int get_invalidTicketsCount() { return _invalidTicketsCount; }
    public void set_invalidTicketsCount(int _invalidTicketsCount) { this._invalidTicketsCount = _invalidTicketsCount; }
    public int get_zoneToControl() { return _zoneToControl; }


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
            ConsoleColors.success("Kontrolleur doesn't need a ticket");
        else if (person instanceof VBMitarbeiter)
            ConsoleColors.success("VB Mitarbeiter doesn't need a ticket");
    }

    private boolean ticketIsValid(Person person, Ticket ticket)
    {
        if (!person.get_name().equals(ticket.get_owner())) {
            ConsoleColors.error("Ticket does not belong to this person");
            return false;
        }

        if (!ticket.gueltigInZone(get_zoneToControl())) {
            ConsoleColors.error("Ticket not valid in this zone");
            return false;
        }

        if (ticket instanceof Einzelticket einzelticket) {
            if (einzelticket.istEntwertet()) {
                ConsoleColors.warning("Ticket was already used");
                return false;
            }
            if (einzelticket.get_validUntil().isBefore(LocalDateTime.now())) {
                ConsoleColors.error("Ticket expired");
                return false;
            }
        } else if (ticket instanceof Mehrfachticket mehrfachticket) {
            if (mehrfachticket.get_ridesLeft() <= 0) {
                ConsoleColors.error("No rides left on this ticket");
                return false;
            }
        } else if (ticket instanceof Jahresabo jahresabo) {
            if (jahresabo.get_validUntil().isBefore(LocalDate.now())) {
                ConsoleColors.error("Jahresabo expired");
                return false;
            }
        }
        ConsoleColors.success("Ticket is valid");
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
