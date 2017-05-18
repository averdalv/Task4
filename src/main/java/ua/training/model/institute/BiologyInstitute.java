package ua.training.model.institute;

import ua.training.model.Faculty;
import ua.training.model.Student;

public class BiologyInstitute extends Institute {
    public boolean addStudent(Student student) {
        if(student.getFaculty()== Faculty.BIOLOGY) {
            return super.addStudent(student);
        }
        else {
            return false;
        }
    }
}
