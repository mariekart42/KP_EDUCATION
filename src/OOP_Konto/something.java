package OOP_Konto;

public class something {
    public static void main(String[] args) {
        /*Testen Sie das Ganze, in dem Sie zwei Konto-Objekte erstellen,
        sowie ein Bank-Konto-Objekt, dass über eine hohe Summe an Geld verfügt.*/

        Konto k1 = new Konto("Marie", "Mensing", 8009L, 1.5);
        Konto k2 = new Konto("Marie2", "Mensing2", 80010L, 100);

        Konto bank = new Konto("Marie3", "Mensing3", 5656565, Double.MAX_VALUE);
        k1.print();
        k2.print();

//        bank.print();
//        bank.abbuchung(10);
        k1.zubuchung(20000);
        k1.print();
        k2.abbuchung(20000);
        k2.print();


    }
}
