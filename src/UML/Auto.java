package UML;

public class Auto extends Fahrzeug {
    private final double _maxSpeed = 140;
    private final double _amountWheels = 4;

    @Override
    public double get_maxSpeed() { return _maxSpeed; }
    @Override
    public double get_amountWheels() { return _amountWheels; }
}
