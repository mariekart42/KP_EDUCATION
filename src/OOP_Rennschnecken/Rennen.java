package OOP_Rennschnecken;

public class Rennen {
    private String _name;
    private int _amountParticipants;
    private Rennschnecke[] _participants;
    private double _pathToAccomplish;

    public Rennen(String name, double pathToAccomplish)
    {
        set_name(name);
        set_participants(new Rennschnecke[0]);
        set_pathToAccomplish(pathToAccomplish);
    }

    public String get_name() { return _name; }

    public void set_name(String _name) { this._name = _name; }

    public int get_amountParticipants() { return _amountParticipants; }

    public void set_amountParticipants(int _amountParticipants) { this._amountParticipants = _amountParticipants; }

    public Rennschnecke[] get_participants() { return _participants; }

    public void set_participants(Rennschnecke[] _participants) { this._participants = _participants; }

    public double get_pathToAccomplish() { return _pathToAccomplish; }

    public void set_pathToAccomplish(double _pathToAccomplish) { this._pathToAccomplish = _pathToAccomplish; }

    public void addRennschnecke(Rennschnecke newSnail)
    {
        Rennschnecke[] newSnails = new Rennschnecke[get_amountParticipants() + 1];
        Rennschnecke[] snails = get_participants();
        int i;

        for (i = 0; i < snails.length; i++)
        {
            newSnails[i] = snails[i];
        }
        newSnails[i] = newSnail;
        set_amountParticipants(get_amountParticipants() + 1);
        set_participants(newSnails);
    }

    public Rennschnecke ermittleGewinner()
    {
        for (Rennschnecke snail : get_participants())
        {
            if (snail.get_accomplishedPath() >= get_pathToAccomplish())
                return snail;
        }
        return null;
    }

    public void lasseSchneckenKriechen()
    {
        for (Rennschnecke snail : get_participants())
        {
            snail.krieche();
        }
    }

    public void durchfuehren()
    {
        while (ermittleGewinner() == null)
        {
            lasseSchneckenKriechen();
        }
    }


    public String toString()
    {
        String result = "\n\tLength of " + get_name() + ": \033[1m" + get_pathToAccomplish() + "mm\033[0m\n" +
                "\tParticipants: [\033[1m" + get_amountParticipants() + "\033[0m]\n";
        for (Rennschnecke snail : get_participants())
        {
            result += "\t\t- \033[1m" + snail.get_name() + "\033[0m\n";
        }
        return result + "\n";
    }
}
