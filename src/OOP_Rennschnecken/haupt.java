package OOP_Rennschnecken;

import OOP_Konto.Konto;

public class haupt {
    public static void main(String[] args) {
        Rennschnecke s1 = new Rennschnecke("Schnegge1", Rennschnecke.BREED.GARDEN_SNAIL, 10, 0);
        Rennschnecke s2 = new Rennschnecke("Schnegge2", Rennschnecke.BREED.GLASS_SNAIL, 10, 0);
        Rennschnecke s3 = new Rennschnecke("Schnegge3", Rennschnecke.BREED.LAND_SNAIL, 10, 0);
//
//        s1.krieche();
//        s2.krieche();
//        s3.krieche();

        // print(object) automatically calls toString(),
        // therefore overriding toString in class Rennschnecke gives us the expected output
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        Rennen r = new Rennen("Rennen1", 50);
        r.addRennschnecke(s1);
        r.addRennschnecke(s2);
        r.addRennschnecke(s3);
        System.out.println(r);

        r.durchfuehren();
        System.out.println("Gewinner: " + r.ermittleGewinner());

        Konto player1 = new Konto("player", "1", 999, 100);
        Konto player2 = new Konto("player", "2", 998, 1000);
        Konto player3 = new Konto("player", "3", 997, 10000);

        Wettbuero wb = new Wettbuero(r);
        wb.wetteAnnehmen(s1.get_name(), (int) (Math.random() * 100), player1);
        wb.wetteAnnehmen(s2.get_name(), (int) (Math.random() * 100), player2);
        wb.wetteAnnehmen(s3.get_name(), (int) (Math.random() * 100), player3);
        System.out.println(wb);
//
        wb.rennenDurchfuehren();
    }
}
