package UML;

public abstract class Fahrzeug {
    private double _currentPos;
    private double _currentSpeed;
    private final double _maxSpeed = 0;
    private final double _amountWheels = 0;

    public double get_currentPos() { return _currentPos; }
    public double get_maxSpeed() { return _maxSpeed; }
    public double get_currentSpeed() { return _currentSpeed; }
    public double get_amountWheels() { return _amountWheels; }
    public void set_currentSpeed(double _currentSpeed) { this._currentSpeed = _currentSpeed; }
    public void set_currentPos(double _currentPos) { this._currentPos = _currentPos; }

    public void bewege(double minuten)
    {
        if (get_currentSpeed() > 0)
            set_currentPos(get_currentPos() + (get_currentSpeed() / 60.0) * minuten);
    }

    public void setzeGeschwindigkeit(double speed)
    {
        if (speed < get_maxSpeed())
        {
            System.out.printf("Speed for %s set to %.2f\n", this.getClass().getSimpleName(), speed);
            set_currentSpeed(speed);
        }
        else
            System.out.printf("Speed %.2f is too high for %s\n", speed, this.getClass().getSimpleName());
    }
}
