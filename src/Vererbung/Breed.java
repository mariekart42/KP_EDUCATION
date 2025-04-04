package Vererbung;

public class Breed extends Dog {
    private String _colour;

    public Breed(String name, int age, String colour)
    {
        super(name, age);
        set_colour(colour);
        System.out.println("Breed Konstruktor");
    }


    public String get_colour() {
        return _colour;
    }

    public void set_colour(String _colour) {
        this._colour = _colour;
    }
}
