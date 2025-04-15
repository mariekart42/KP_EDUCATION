package ArrayListTask.Tickets;

public abstract class Person {
    private String _name;

    public Person(String name)
    {
        set_name(name);
    }


    public String get_name() { return _name; }
    public void set_name(String _name) { this._name = _name; }
}
