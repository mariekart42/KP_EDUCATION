package ArrayListTask.Arithmetic.Math;

import ArrayListTask.Arithmetic.Ausdruck;
import ArrayListTask.Arithmetic.Binaeroperationen;

public class Subtraktion extends Binaeroperationen {
    public Subtraktion(Ausdruck left, Ausdruck right) {
        super(left, right);
    }

    @Override
    public int eval() {
        return _left.eval() - _right.eval();
    }

    @Override
    public String toString() {
        return "(" + _left.toString() + " - " + _right.toString() + ")";
    }
}
