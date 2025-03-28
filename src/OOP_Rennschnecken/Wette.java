package OOP_Rennschnecken;

import OOP_Konto.Konto;

public class Wette {
    private String _snailName;
    private int _moneyToBet;
    private Konto _player;

    public Wette(String snailName, int moneyToBet, Konto player)
    {
        set_snailName(snailName);
        set_moneyToBet(moneyToBet);
        set_player(player);
    }

    public String get_snailName() { return _snailName; }

    public void set_snailName(String _snailName) { this._snailName = _snailName; }

    public int get_moneyToBet() { return _moneyToBet; }

    public void set_moneyToBet(int _moneyToBet) { this._moneyToBet = _moneyToBet; }

    public Konto get_player() { return _player; }

    public void set_player(Konto _player) { this._player = _player; }

    public String toString()
    {
        return "\t" + get_player().get_vorname() + " " + get_player().get_nachname() +
                " bets \033[1m" + get_moneyToBet() + " Moneys\033[0m on \033[1m" + get_snailName() + "\033[0m\n";
    }
}
