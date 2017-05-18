package ua.training.model;

import ua.training.model.institute.BiologyInstitute;
import ua.training.model.institute.CommonInstitute;
import ua.training.model.institute.Institute;
import ua.training.model.institute.MathInstitute;
import java.util.concurrent.BlockingQueue;

public class InstituteManager extends Thread {
    private BlockingQueue<Student> queue;
    private Institute[] institutes ;
    public InstituteManager(BlockingQueue<Student> queue) {
        this.queue = queue;
        institutes = new Institute[]{new BiologyInstitute(),new CommonInstitute(),new MathInstitute()};
    }
    public Institute[] getInstitutes() {
        return institutes;
    }
    public boolean addStudentToInstituteByIndex(int index,Student student) {
        return institutes[index%institutes.length].addStudent(student);
    }
    public void run() {
        int i=0;
        while(!queue.isEmpty()) {
            Student studentToAdd = queue.poll();
            if(addStudentToInstituteByIndex(i,studentToAdd)) {
                Sleep(50);
            }
            else {
                i++;
                if(!addStudentToInstituteByIndex(i,studentToAdd)) {
                    i++;
                    addStudentToInstituteByIndex(i,studentToAdd);
                }
            }
        }
    }

    public void Sleep(int mSeconds) {
        try{

            Thread.sleep(mSeconds);
        }
        catch (InterruptedException ex) {
            System.err.print(ex.getMessage());
        }
    }
    public BlockingQueue<Student> getQueue() {
        return queue;
    }
}
