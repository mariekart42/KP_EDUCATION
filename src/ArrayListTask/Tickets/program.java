package ArrayListTask.Tickets;

import java.util.ArrayList;

public class program {
    public static void main(String[] args) {

        ArrayList<Person> tram = new ArrayList<>();

        Ticket ticket1 = new Einzelticket(3, 12);

        Fahrgast gast1 = new Fahrgast("fahrgast1", ticket1);
        Fahrgast gast2 = new Fahrgast("fahrgast2", ticket1);

        tram.add(gast1);
        tram.add(gast2);


        //tram.add(new Kontrolleur("kontrolleur"));
        tram.add(new VBMitarbeiter("vb Mitarbeiter"));



        for (Person p : tram)
        {
            if (p instanceof Fahrgast)
            {
                System.out.println("Fahrgast: " + p);
            }
        }
    }
}
