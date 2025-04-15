package ArrayListTask.Tickets;

import java.time.LocalDate;

public class Jahresabo extends Ticket {
    private final LocalDate _validUntil;

    public Jahresabo(String owner, int preis) {
        super(owner, preis);
        this._validUntil = LocalDate.of(LocalDate.now().getYear(), 12, 31);
    }

    public LocalDate get_validUntil() { return _validUntil; }

    @Override
    public boolean gueltigInZone(int zone)
    {
        return true;
    }

    @Override
    public String toString()
    {
        return "\nJahresabo valid in all Zones till: " + get_validUntil();
    }
}
