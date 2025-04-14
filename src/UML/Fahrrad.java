package UML;

public class Fahrrad extends Fahrzeug {
    private final double _maxSpeed = 30;
    private final double _amountWheels = 2;

    @Override
    public double get_maxSpeed() { return _maxSpeed; }
    @Override
    public double get_amountWheels() { return _amountWheels; }
}
