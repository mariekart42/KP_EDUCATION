package ArrayListTask.Arithmetic.Math;

import ArrayListTask.Arithmetic.Ausdruck;
import ArrayListTask.Arithmetic.Binaeroperationen;

public class Multiplikation extends Binaeroperationen {
    public Multiplikation(Ausdruck left, Ausdruck right) {
        super(left, right);
    }

    @Override
    public int eval() {
        return _left.eval() * _right.eval();
    }

    @Override
    public String toString() {
        return "(" + _left.toString() + " * " + _right.toString() + ")";
    }
}
