package ua.training;


import ua.training.controller.Controller;
import ua.training.model.InstituteManager;
import ua.training.model.QueueManager;
import ua.training.model.Student;
import ua.training.view.View;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App
{
    public static void main( String[] args ) {
        BlockingQueue<Student> queue = new LinkedBlockingQueue<Student>();
        InstituteManager instituteManager = new InstituteManager(queue);
        QueueManager queueManager = new QueueManager(queue);
        View view = new View();
        Controller controller = new Controller(view,instituteManager,queueManager);
        controller.processUser();
    }
}
