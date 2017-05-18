package ua.training.model;

public class Student {
    private Faculty faculty;
    public Student(Faculty faculty) {
        this.faculty = faculty;
    }
    public Faculty getFaculty() {
        return faculty;
    }
}
