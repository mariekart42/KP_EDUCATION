package UML;

public class Krankenwagen extends Auto {
    private boolean isBlueLightOn;

    public boolean isBlueLightOn() { return isBlueLightOn; }
    public void setBlueLightOn(boolean blueLightOn) { isBlueLightOn = blueLightOn; }

    public void turnBlueLight(boolean state)
    {
        setBlueLightOn(state);
        System.out.printf("Turned Blue Light %s", state ? "on":"off");
    }
}
