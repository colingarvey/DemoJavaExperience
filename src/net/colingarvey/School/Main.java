package net.colingarvey.School;


import java.util.ArrayList;

/**
 * Examples of object oriented programming.
 */
public class Main {
    // public Student(String name, String address, String major, int age) {
    public static void main(String[] args){
        Student student1 = new Student("Colin Garvey", "1 Main St", "Computer Science", 30);
        Student student2 = new Student("Bob Johnson", "29 Main St", "Biology", 21);
        Student student3 = new Student("Billy Bob Thornton", "1 Broadway", "Anthropology", 33);
        Student student4 = new Student("Barry Bonds", "1 Main St", "Mathematics", 34);

        Professor prof1 = new Professor("Michael J Fox",
                "221 Spring St.",
                "Math",
                5
                );
        Professor prof2 = new Professor("Charles Darwin",
                "123 Main St",
                "Anthropology",
                10
        );

        ArrayList<Student> anthroStudents = new ArrayList<>();
        anthroStudents.add(student2);
        anthroStudents.add(student3);

        ArrayList<Student> calcStudents = new ArrayList<>();
        calcStudents.add(student1);
        calcStudents.add(student4);

        Course course1 = new Course("Physical Anthropology", prof2, anthroStudents);
        Course course2 = new Course("Calculus II", prof1, calcStudents);
        System.out.println(course1);
        System.out.println(course2);
        System.out.println();

        System.out.printf("Students for %s\n", course1.name);
        for (Student student : course1.students){
            System.out.println(student);
        }
        System.out.println();


        System.out.printf("Students for %s\n", course2.name);
        for (Student student : course2.students){
            System.out.println(student);
        }


    }
}

