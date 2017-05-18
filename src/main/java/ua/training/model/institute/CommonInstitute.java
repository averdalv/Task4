package ua.training.model.institute;

import ua.training.model.Student;

import java.util.Random;

public class CommonInstitute extends Institute{
    private int randomStudensNumber;
    private final int MAXIMAL_STUDENTS_NUMBER = 5;
    private final int MINIMAL_STUDENTS_NUMBER = 1;
    public CommonInstitute() {
        super();
        updateRandomNumber();
    }
    private void updateRandomNumber() {
        Random random = new Random();
        randomStudensNumber = random.nextInt(MAXIMAL_STUDENTS_NUMBER)+ MINIMAL_STUDENTS_NUMBER;
    }
    public boolean addStudent(Student student) {
        if(randomStudensNumber >= MINIMAL_STUDENTS_NUMBER) {
            super.addStudent(student);
            randomStudensNumber--;
            return true;
        }
        else {
            updateRandomNumber();
            return false;
        }
    }
}
