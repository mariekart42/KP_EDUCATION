package ArrayListTask.Arithmetic;

public abstract class Binaeroperationen extends Ausdruck {

    protected Ausdruck _left;
    protected Ausdruck _right;

    public Binaeroperationen(Ausdruck left, Ausdruck right)
    {
        this._left = left;
        this._right = right;
    }
}
