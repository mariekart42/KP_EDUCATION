package moreUMLTasks;

public class Hund
{
    private String rasse;
    private String fellfarbe;
    public int anzahlBefehle; // Befehle, die der Hund kennt

    public Hund(String rasse, String fellfarbe)
    {
        this.rasse = rasse;
        this.fellfarbe = fellfarbe;
    }

    public int befehleBerechnen(int alter, String hundeschule) {
        String trainingsziel = "";
        int faktorisiertesAlter = alter > 10 ? alter * 100 : alter * 50;
        switch(faktorisiertesAlter) {
            case 100:
                trainingsziel = hundeschule + ", Gold-Diplom";
                break;
            default:
                trainingsziel = hundeschule + ", Standard-Diplom";
                break;
        }
        return faktorisiertesAlter;
    }
}



