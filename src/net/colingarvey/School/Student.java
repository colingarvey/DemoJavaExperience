package net.colingarvey.School;

public class Student extends Person {
    private String major;
    private int age;
    private int coursesAttending;

    public Student(String name, String address, String major, int age) {
        super(name, address);
        this.major = major;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString(){
        return String.format("<Student '%s' major='%s' age=%d>", this.name, this.major, this.age);
    }
}
