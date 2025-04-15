package ArrayListTask.Tickets;

public class VBMitarbeiter extends Person {
    public VBMitarbeiter(String name)
    {
        super(name);
    }

    @Override
    public String toString()
    {
        return "I'm VBMitarbeiter " + get_name() + ", i don't need tickets";
    }
}
