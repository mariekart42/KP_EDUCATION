package Vererbung;

public abstract class Animal {
    private String _color;

    public String get_color() { return _color; }
    public void set_color(String _color) { this._color = _color; }

    public abstract void eat();
}
