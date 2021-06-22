package net.colingarvey.School;

public class Professor extends Person {
    private String specialty;
    private final int tenure;
    private int coursesTaught;

    public Professor(String name, String address, String specialty, int tenure) {
        super(name, address);
        this.tenure = tenure;
        this.specialty = specialty;

    }

    public int getTenure() {
        return this.tenure;
    }

    public int getCoursesTaught() {
        return this.coursesTaught;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public String toString() {
        return this.getName();
    }
}
