package OOP_Tasks3;

public class Course {
    private String _name;
    private int _year;
    private double _grade;

    public Course(String name, int year, double grade)
    {
        set_name(name);
        set_year(year);
        set_grade(grade);
    }

    public String get_name() { return _name; }

    public void set_name(String _name) { this._name = _name; }

    public int get_year() { return _year; }

    public void set_year(int _year) { this._year = _year; }

    public double get_grade() { return _grade; }

    public void set_grade(double _grade) { this._grade = _grade; }

    public String toString()
    {
        return "\n - Course Name: " + get_name() + ", year: " + get_year() + ", grade: " + get_grade();
    }
}
