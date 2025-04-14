package ArrayListTask.Arithmetic;

public class Literal extends Ausdruck {
    private int _wert;

    public Literal(int wert) {
        this._wert = wert;
    }

    @Override
    public int eval() {
        return _wert;
    }

    @Override
    public String toString() {
        return String.valueOf(_wert);
    }
}
