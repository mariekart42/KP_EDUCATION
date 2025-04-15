package ArrayListTask.Tickets;

public abstract class Person {
    private final String _name;

    public Person(String name)
    {
        this._name = name;
    }

    public String get_name() { return _name; }
}
