package ArrayListTask.Tickets;

import java.util.ArrayList;

public class program {
    public static void main(String[] args) {

        ArrayList<Person> tram = new ArrayList<>();

        Ticket ticket1 = new Einzelticket("fahrgast1", 3, 12);
        Ticket ticket2 = new Einzelticket("fahrgast2", 5, 12);

        Fahrgast gast1 = new Fahrgast("fahrgast1", ticket1);
        Fahrgast gast2 = new Fahrgast("fahrgast2", ticket2);

        tram.add(gast1);
        tram.add(gast2);
        tram.add(gast2);

        TarifbereichKontrolleur kontrolleur = new TarifbereichKontrolleur("kontrolleur", 12);

        tram.add(new TarifbereichKontrolleur("kontrolleur", 12));
        tram.add(new VBMitarbeiter("vb Mitarbeiter"));

        for (Person p : tram)
        {
            System.out.println("\nCheck ticket of " + p.get_name());
            kontrolleur.checkTicket(p);
        }
    }
}
