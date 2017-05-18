package ua.training.controller;

import ua.training.model.InstituteManager;
import ua.training.model.QueueManager;
import ua.training.model.Student;
import ua.training.model.institute.Institute;
import ua.training.view.View;

import java.util.concurrent.BlockingQueue;

public class Controller {
    private InstituteManager instituteManager;
    private QueueManager queueManager;
    private View view;
    public Controller(View view, InstituteManager instituteManager, QueueManager queueManager) {
        this.view = view;
        this.queueManager = queueManager;
        this.instituteManager = instituteManager;
    }
    public void processUser() {
        view.printStartState();
        printState(instituteManager.getInstitutes());
        BlockingQueue<Student> queue = instituteManager.getQueue();
        startThreads();
        sleepSecond();
        while(!queue.isEmpty()) {
            view.printIntermediateState();
            printState(instituteManager.getInstitutes());
            sleepSecond();
        }
        view.printFinishState();
        printState(instituteManager.getInstitutes());

    }
    public void startThreads() {
        queueManager.start();
        instituteManager.start();
    }
    public void printState(Institute []institutes) {
        view.printInstitutes(institutes);
    }
    public void sleepSecond() {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {

        }
    }
}
