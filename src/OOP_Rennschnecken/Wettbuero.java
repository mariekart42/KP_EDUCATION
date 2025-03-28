package OOP_Rennschnecken;

import OOP_Konto.Konto;

import java.util.Objects;

public class Wettbuero {
    private Rennen _race;
    private Wette[] _acceptedBets;
    public static final int winMultiplier = 2;

    public Wettbuero(Rennen race)
    {
        set_race(race);
        set_acceptedBets(new Wette[0]);
    }


    public Rennen get_race() { return _race; }

    public void set_race(Rennen _race) { this._race = _race; }

    public Wette[] get_acceptedBets() { return _acceptedBets; }

    public void set_acceptedBets(Wette[] _acceptedBets) { this._acceptedBets = _acceptedBets; }


    public void wetteAnnehmen(String snailName, int moneyToBet, Konto player)
    {
        if (player.get_stand() - moneyToBet <= 0)
            System.out.printf("Sorry %s %s you don't have enough money to bet %d Moneys.\n\n",
                    player.get_vorname(), player.get_nachname(), moneyToBet);
        else
            player.abbuchung(moneyToBet);

        Wette[] newBets = new Wette[get_acceptedBets().length + 1];
        int i;
        for (i = 0; i < get_acceptedBets().length; i++)
        {
            newBets[i] = get_acceptedBets()[i];
        }
        newBets[i] = new Wette(snailName, moneyToBet, player);
        set_acceptedBets(newBets);
    }

    public void rennenDurchfuehren()
    {
        get_race().durchfuehren();

        Rennschnecke winner = get_race().ermittleGewinner();

        for (Wette bet : get_acceptedBets())
        {
            Konto player = bet.get_player();
            if (Objects.equals(bet.get_snailName(), winner.get_name()))
            {
                int wonMoney = bet.get_moneyToBet() * winMultiplier;
                player.zubuchung(wonMoney);
                System.out.printf("\033[32mCongrats %s %s you won \033[1m%d Moneys\033[0m\033[32m. You now have \033[1m%.2f Moneys\033[0m\n\n",
                        player.get_vorname(), player.get_nachname(), wonMoney, player.get_stand());
            }
            else
            {
                System.out.printf("\033[31mSorry %s %s you lost \033[1m%d Moneys\033[0m\033[31m. You now have \033[1m%.2f Moneys\033[0m\n\n",
                        player.get_vorname(), player.get_nachname(), bet.get_moneyToBet(), player.get_stand());
            }
        }
    }

    public String toString()
    {
        String result = "\n\n\033[1m>>> --------- WETTBUERO INFO --------- <<<\033[0m\n";
        result += "\t\t\t\t  \033[1m"+get_race().get_name()+"\033[0m\n";
        result += get_race();
        for (Wette bet : get_acceptedBets())
        {
            result += bet;
        }
        result += "\n\t[The win multiplier is: " + winMultiplier + "]\n\033[1m<<< ----------------------------------- >>>\033[0m\n\n";
        return result;
    }
}
