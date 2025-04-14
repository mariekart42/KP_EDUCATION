package ArrayListTask.Tickets;

import java.util.ArrayList;

public class program {
    public static void main(String[] args) {

        ArrayList<Person> personen = new ArrayList<>();
        personen.add(new Fahrgast());
        personen.add(new Fahrgast());
        personen.add(new Kontrolleur());
        personen.add(new VBMitarbeiter());
    }
}
