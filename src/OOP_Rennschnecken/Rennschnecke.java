package OOP_Rennschnecken;

public class Rennschnecke {

    public enum BREED
    {
        LAND_SNAIL,
        GLASS_SNAIL,
        GARDEN_SNAIL
    }

    private String _name;
    private BREED _breed;
    private int _maxSpeed;
    private double _accomplishedPath;

    public Rennschnecke(String name, BREED breed, int maxSpeed, double accomplishedPath)
    {
        set_name(name);
        set_breed(breed);
        set_maxSpeed(maxSpeed);
        set_accomplishedPath(accomplishedPath);
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public BREED get_breed() {
        return _breed;
    }

    public void set_breed(BREED _breed) {
        this._breed = _breed;
    }

    public int get_maxSpeed() {
        return _maxSpeed;
    }

    public void set_maxSpeed(int _maxSpeed) {
        this._maxSpeed = _maxSpeed;
    }

    public double get_accomplishedPath() {
        return _accomplishedPath;
    }

    public void set_accomplishedPath(double _accomplishedPath) {
        this._accomplishedPath = _accomplishedPath;
    }

    public void krieche()
    {
        // 1 + Math.Random so number will be above 0
        // get_maxSpeed() - 1 cause krieche should be below maxSpeed
        set_accomplishedPath(get_accomplishedPath() + (1 + Math.random() * (get_maxSpeed() - 1)));
    }

    public String toString()
    {
        return "\n\tName:\t\t\033[1m" + get_name() + "\033[0m\n\tBreed:\t\t" + get_breed() +
                "\n\tMax Speed:\t" + get_maxSpeed() + "\n\tDistance:\t" + get_accomplishedPath() + "\n";
    }
}
