package net.colingarvey.School;

import java.util.ArrayList;
import java.util.List;

class Course {
    public String name;
    protected Professor professor;
    protected List<Student> students;

    /** Course main constructor **/
    public Course(String name, Professor professor, ArrayList<Student> students) {
        this.name = name;
        this.professor = professor;
        this.students = students;
    }

    /** Course alternative constructor **/
    public Course(String name) {
        this.name = name;
    }

    /** Add student to course **/
    public void addStudent(Student student) {
        this.students.add(student);
    }

    /** Set professor for course **/
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String toString(){
        return String.format("<Course '%s' taught by %s>", this.name, this.professor);
    }
}
