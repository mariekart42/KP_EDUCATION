package OOP_Konto;

public class Konto {
    private String _nachname;
    private String _vorname;
    private long _nr;
    private double _stand;
    private double _summeZugaenge;
    private double _summeAbgaenge;


    public Konto(String vorname, String nachname, long nr, double stand)
    {
        set_vorname(vorname);
        set_nachname(nachname);
        set_nr(nr);
        set_stand(stand);
    }

    public String get_nachname() { return _nachname; }

    public void set_nachname(String _nachname) { this._nachname = _nachname; }

    public String get_vorname() { return _vorname; }

    public void set_vorname(String _vorname) { this._vorname = _vorname; }

    public long get_nr() { return _nr; }

    public void set_nr(long _nr) { this._nr = _nr; }

    public double get_stand() { return _stand; }

    public void set_stand(double _stand) { this._stand = _stand; }

    public void init(String nachname, long nr, double stand)
    {
        set_nachname(nachname);
        set_nr(nr);
        set_stand(stand);
    }

    public void print()
    {
        System.out.printf("%s %s – %d\n", get_nachname(), get_vorname(), get_nr());
        System.out.printf("---------------------------------------------\n");
        System.out.printf("Aktueller Kontostand: %f\n\n", get_stand());
        System.out.println("Summe der Zugänge in der Durchführung: " + get_summeZugaenge());
        System.out.println("Summe der Abgaenge in der Durchführung: " + get_summeAbgaenge() + "\n\n");
    }

    public double get_summeZugaenge() {
        return _summeZugaenge;
    }

    public void set_summeZugaenge(double _summeZugaenge) {
        this._summeZugaenge = _summeZugaenge;
    }

    public double get_summeAbgaenge() {
        return _summeAbgaenge;
    }

    public void set_summeAbgaenge(double _summeAbgaenge) {
        this._summeAbgaenge = _summeAbgaenge;
    }

    public void zubuchung(double sum)
    {
        set_summeZugaenge(get_summeZugaenge() + sum);
        set_stand(get_stand() + sum);
    }
    public void abbuchung(double minus)
    {
        double sum = get_summeAbgaenge() - minus;
        if ((get_stand() - minus) < 0)
        {
            System.out.println("Kontostand wuerde unter 0 sein. Buchung Abbruch");
            return;
        }
        set_summeAbgaenge(sum);
        set_stand(get_stand() - minus);
    }
}
