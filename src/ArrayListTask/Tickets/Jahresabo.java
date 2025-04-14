package ArrayListTask.Tickets;

public class Jahresabo extends Ticket {

    public Jahresabo(int preis) {
        super(preis);
    }

    @Override
    public boolean gueltigInZone(int zone) {
        return true;
    }
}
