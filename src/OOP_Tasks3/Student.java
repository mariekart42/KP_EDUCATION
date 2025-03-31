package OOP_Tasks3;
import java.util.GregorianCalendar;

public class Student {
    private String _name;
    private GregorianCalendar _birthdate;
    private int _matriculationNumber;
    private Course[] _courses;
    private char _gender;

    public Student(String name, GregorianCalendar birthdate, int matriculationNumber, Course[] courses, char gender)
    {
        set_name(name);
        set_birthdate(birthdate);
        set_matriculationNumber(matriculationNumber);
        set_courses(courses);
        set_gender(gender);
    }

    public String get_name() { return _name; }

    public void set_name(String _name) { this._name = _name; }

    public GregorianCalendar get_birthdate() { return _birthdate; }

    public void set_birthdate(GregorianCalendar _birthdate) { this._birthdate = _birthdate; }

    public int get_matriculationNumber() { return _matriculationNumber; }

    public void set_matriculationNumber(int _matriculationNumber) { this._matriculationNumber = _matriculationNumber; }

    public Course[] get_courses() { return _courses; }

    public void set_courses(Course[] _courses) { this._courses = _courses; }

    public char get_gender() { return _gender; }

    public void set_gender(char _gender) { this._gender = _gender; }

    public String toString()
    {
        String birthdate = get_birthdate().get(GregorianCalendar.DAY_OF_MONTH) + "." + get_birthdate().get(GregorianCalendar.MONTH) + "." + get_birthdate().get(GregorianCalendar.YEAR);
        StringBuilder result = new StringBuilder("\n\nName:\t " + get_name() + "\nBirth:   " + birthdate + "\nNummer: " + get_matriculationNumber());
        result.append("\nCOURSES:");
        for (Course course : get_courses())
        {
            result.append(course);
        }
        result.append("\nGender:  ").append(get_gender());
        return result.toString();
    }
}
