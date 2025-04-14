package ArrayListTask.Arithmetic;

import ArrayListTask.Arithmetic.Math.Addition;
import ArrayListTask.Arithmetic.Math.Division;
import ArrayListTask.Arithmetic.Math.Multiplikation;
import ArrayListTask.Arithmetic.Math.Subtraktion;

public class program {
    public static void main(String[] args) {
        Literal li1 = new Literal(3);
        Literal li2 = new Literal(12);
        Literal li3 = new Literal(2);
        Literal li4 = new Literal(4);
        Literal li5 = new Literal(7);
        Addition a = new Addition(li1, li2);
        Multiplikation m = new Multiplikation(li3, a);
        Subtraktion s = new Subtraktion(m, li4);
        Division d = new Division(s, li5);
        System.out.println(d + " = " + d.eval());
    }
}
