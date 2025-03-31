package OOP_Tasks3;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class program {
    public static void main(String[] args) {

        try
        {

            Course[] courses = new Course[]
                {
                        new Course("c1", 2023, 2.4),
                        new Course("c2", 2023, 3.4),
                        new Course("c3", 2023, 4.4),
                };
            GregorianCalendar birth = new GregorianCalendar(2002, Calendar.JUNE, 11);

    //        Student student = new Student("Me", birth, 99, courses, 'm');
    //        System.out.println(student);

            // Task 5
    //        Student[] students = new Student[100];
    //        for (int i = 0; i < students.length; i++)
    //        {
    //            students[i] = new Student("student "+i, birth, i, courses, 'm');
    //            System.out.println(students[i] + "\n\n");
    //        }

            // Task 6
            int amountStudents = 50;
            StudentDB db = new StudentDB(amountStudents);
            for (int i = 0; i < amountStudents; i++)
            {
                db.addStudent("student " + i, birth, i, courses, 'm');
            }
            //System.out.println(db);


            // Task 7
    //        db.deleteStudent(3);
    //        System.out.println(db);


            // Task 8
            System.out.println(db.countStudents());
            db.deleteStudent(20);
            System.out.println(db.countStudents());
            db.addStudent("name", birth, 20, courses, 'm');
            System.out.println(db.countStudents());
            db.deleteStudent(31);
            System.out.println(db.countStudents());


            // Task 9

    //        db.deleteStudent(20);
    //        db.deleteStudent(21);
    //        db.deleteStudent(22);
    //        db.deleteStudent(23);
    //
    //        db.addStudent("aaa", birth, 20, courses, 'm');
    //        db.addStudent("aab", birth, 21, courses, 'm');
    //        db.addStudent("abb", birth, 22, courses, 'm');
    //        db.addStudent("bbb", birth, 23, courses, 'm');
            db.deleteStudent(20);
            db.deleteStudent(21);
            db.deleteStudent(22);
            db.deleteStudent(23);
    //
    //        db.sortStudents(db.get_students(), StudentDB.SORT.NAME);
    //        System.out.println("\n\nSORT FOR NAME:\n"+db);


            birth.add(Calendar.DAY_OF_MONTH, 2);
            db.addStudent("aaa", birth, 20, courses, 'm');
            GregorianCalendar newDate1 = (GregorianCalendar) birth.clone();
            newDate1.add(Calendar.DAY_OF_MONTH, 4);
            db.addStudent("bbb", newDate1, 21, courses, 'm');
            GregorianCalendar newDate2 = (GregorianCalendar) birth.clone();
            newDate2.add(Calendar.DAY_OF_MONTH, 60);
            db.addStudent("bba", newDate2, 22, courses, 'm');
            GregorianCalendar newDate3 = (GregorianCalendar) birth.clone();
            newDate3.add(Calendar.DAY_OF_MONTH, 1000);
            db.addStudent("baa", newDate3, 23, courses, 'm');
    //
    //        db.sortStudents(db.get_students(), StudentDB.SORT.AGE);
    //        System.out.println("\n\nSORT FOR AGE:\n"+db);


    //        db.sortStudents(db.get_students(), StudentDB.SORT.MAT_NO);
    //        System.out.println("\n\nSORT FOR MATRICULATION NUMBER:\n"+db);



            // Task 10
    //        Course[] newCourses = new Course[]
    //                {
    //                        new Course("special Course", 2023, 2.4),
    //                };
    //        db.deleteStudent(2);
    //        db.deleteStudent(3);
    //        db.deleteStudent(4);
    //
    //        db.addStudent("name", birth, 2, newCourses, 'm');
    //        db.addStudent("name", birth, 3, newCourses, 'm');
    //        db.addStudent("name", birth, 4, newCourses, 'm');
    //        db.sortStudents(db.get_students(), StudentDB.SORT.MAT_NO);
    //        System.out.println("Students that visited course "+ Arrays.toString(db.studentsVisitedCourse("special Course")));


            // Task 11
            db.deleteStudent(24);
            db.deleteStudent(25);
            db.deleteStudent(26);
            db.deleteStudent(27);
            db.addStudent("name", birth, 24, courses, 'f');
            db.addStudent("name", birth, 25, courses, 'f');
            db.addStudent("name", birth, 26, courses, 'f');
            db.addStudent("name", birth, 27, courses, 'q');

            System.out.println("Average Students Age: " + db.calculateAverageAge());
            db.calculateGenderPercentage(db.get_students());
        }
        catch (Exception e)
        {
            System.out.println("\nException: " + e.getMessage());
        }
    }
}
