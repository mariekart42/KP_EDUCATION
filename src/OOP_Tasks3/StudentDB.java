package OOP_Tasks3;

import java.util.GregorianCalendar;
import java.util.Objects;

public class StudentDB {
    public enum SORT
    {
        NAME, AGE, MAT_NO
    }
    private Student[] _students;
    private int _amountStudents;


    public Student[] get_students() { return _students; }
    public void set_students(Student[] _students) { this._students = _students; }
    public int get_amountStudents() { return _amountStudents; }
    public void set_amountStudents(int _amountStudents) { this._amountStudents = _amountStudents; }


    public StudentDB(int amountStudents)
    {
        set_students(new Student[amountStudents]);
    }

    public int countStudents()
    {
        return get_amountStudents();
    }

    public void addStudent(String name, GregorianCalendar birthdate, int matriculationNumber, Course[] courses, char gender)
    {
        Student[] students = get_students();

        if (studentAlreadyExists(matriculationNumber))
        {
            System.out.println("Student wit Matriculation Number " + matriculationNumber + " already exists in DB");
            return;
        }

        if (get_amountStudents() < get_students().length)
        {
            students[get_amountStudents()] = new Student(name, birthdate, matriculationNumber, courses, gender);
            System.out.println("\n\033[32mAdded Student: " + students[get_amountStudents()] + "\033[0m");

            set_amountStudents(get_amountStudents() + 1);
            set_students(students);
        }
        else
            System.out.println("DB is full!");
    }

    private boolean studentAlreadyExists(int matriculationNumber)
    {
        for (Student student : get_students())
        {
            if (student != null && student.get_matriculationNumber() == matriculationNumber)
                return true;
        }
        return false;
    }

    public void deleteStudent(int matriculationNumber)
    {
        if (get_amountStudents() == 0)
        {
            System.out.println("Can't delete student cause DB is empty");
            return;
        }

        Student[] newArray = new Student[get_students().length];
        Student[] students = get_students();

        boolean studentFound = false;
        int i = 0, k = 0;
        for (; i < get_amountStudents(); i++)
        {
            if (students[i].get_matriculationNumber() == matriculationNumber)
            {
                System.out.println("\n\033[31mDeleted Student: " + students[i] + "\033[0m");
                studentFound = true;
                continue;
            }
            newArray[k++] = students[i];
        }

        if (!studentFound)
            System.out.println("Student with Matriculation Number: " + matriculationNumber + " not in DB. Can't delete.");
        else
        {
            set_amountStudents(get_amountStudents()-1);
            set_students(newArray);
        }
    }

    public void sortStudents(Student[] array, SORT sortFor) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int k = 0; k < n - i - 1; k++)
            {
                if (doSwap(array[k], array[k+1], sortFor))
                {
                    Student temp = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = temp;

                }
            }
        }
        set_students(array);
    }

    private boolean doSwap(Student element1, Student element2, SORT sortFor)
    {
        switch (sortFor)
        {
            case NAME:
                if (element1.get_name().compareTo(element2.get_name()) > 0)
                    return true;
                break;
            case AGE:
                if (element1.get_birthdate().compareTo(element2.get_birthdate()) > 0)
                    return true;
                break;
            case MAT_NO:
                if (element1.get_matriculationNumber() > element2.get_matriculationNumber())
                    return true;
        }
        return false;
    }


    public String[] studentsVisitedCourse(String courseOfStudent)
    {
        int count = 0;
        for (Student student : get_students())
        {
            Course[] courses = student.get_courses();
            for (Course course : courses)
            {
                if (Objects.equals(course.get_name(), courseOfStudent))
                    count++;
            }
        }

        String[] studentsInCourse = new String[count];

        for (int i = 0, k = 0; i <= count + 1; i++)
        {
            Course[] courses = get_students()[i].get_courses();
            for (Course course : courses)
            {
                if (Objects.equals(course.get_name(), courseOfStudent))
                {
                    studentsInCourse[k] = String.valueOf(get_students()[i]);
                    k++;
                }
            }
        }
        return studentsInCourse;
    }

    public double calculateAverageAge() throws Exception {
        int totalAge = 0;

        for (Student student : get_students())
        {
            if (student != null)
                totalAge += getStudentAge(student);
        }

        return (double) totalAge / get_amountStudents();
    }

    public int getStudentAge(Student student) throws Exception {
        if (student == null)
            throw new Exception("Student doesn't exist. Can't calculate Age.");

        GregorianCalendar today = new GregorianCalendar();
        int age = today.get(GregorianCalendar.YEAR) - student.get_birthdate().get(GregorianCalendar.YEAR);

        if (today.get(GregorianCalendar.MONTH) < student.get_birthdate().get(GregorianCalendar.MONTH) ||
                (today.get(GregorianCalendar.MONTH) == student.get_birthdate().get(GregorianCalendar.MONTH) && today.get(GregorianCalendar.DAY_OF_MONTH) < student.get_birthdate().get(GregorianCalendar.DAY_OF_MONTH))) {
            age--;
        }
        return age;
    }

    public void calculateGenderPercentage(Student[] students)
    {
        int maleCount = 0;
        int femaleCount = 0;
        int otherCount = 0;

        for (Student student : students)
        {
            if (student == null)
                continue;
            switch (student.get_gender())
            {
                case 'M':
                case 'm':
                    maleCount++;
                    break;
                case 'F':
                case 'f':
                    femaleCount++;
                    break;
                default:
                    otherCount++;
                    break;
            }
        }

        System.out.printf("\nMale Percentage:\t%.2f%%\n", ((double) maleCount / get_amountStudents()) * 100);
        System.out.printf("Female Percentage:\t%.2f%%\n", ((double) femaleCount / get_amountStudents()) * 100);
        System.out.printf("Other Percentage:\t%.2f%%\n", ((double) otherCount / get_amountStudents()) * 100);
    }


    public String toString()
    {
        StringBuilder result = new StringBuilder("\n\n");

        for (int i = 0; i < get_amountStudents(); i++)
        {
            result.append(get_students()[i]).append("\n\n");
        }
        return result.toString();
    }
}
