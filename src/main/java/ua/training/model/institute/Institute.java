package ua.training.model.institute;

import ua.training.model.Student;

import java.util.ArrayList;
import java.util.List;

public abstract class Institute {
    private List<Student> students;

    public Institute() {
        students = new ArrayList<Student>();
    }
    public boolean addStudent(Student student) {
        return students.add(student);
    }
    public int getNumberOfStudents() {
        return students.size();
    }

}
