package Vererbung;

public class Cat extends Animal implements AnimalStuff {
    private String _name;
    public int _age;

    public Cat(String name, int age)
    {
        set_name(name);
        set_age(age);
        System.out.println("Cat Constructor");
    }

    public void set_age(int age) { this._age = age;}
    public String get_name() { return _name; }
    public void set_name(String _name) { this._name = _name; }
    public int get_age() { return _age; }

    @Override
    public void eat()
    {
        System.out.println("Cat eats: slurp slurp");
    }

    @Override
    public void makeSound() {
        System.out.println("Miau");
    }
}
