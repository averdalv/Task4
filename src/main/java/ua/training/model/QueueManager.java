package ua.training.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class QueueManager extends Thread {

    private BlockingQueue<Student> queue;
    private Queue<Student> mathStudents;
    private Queue<Student> biologyStudents;
    private final int numMathStudents = 250;
    private final int numBiologyStudents = 200;
    private final int maxQueueSize = 50;
    public QueueManager(BlockingQueue<Student> queue) {
        this.queue = queue;
        mathStudents = new LinkedList<Student>();
        biologyStudents = new LinkedList<Student>();
        for(int i = 0;i < numMathStudents;i++) {
            mathStudents.add(new Student(Faculty.MATH));
        }
        for(int i = 0;i<numBiologyStudents;i++) {
            biologyStudents.add(new Student(Faculty.BIOLOGY));
        }
    }
    public boolean addRandomStudentsToQueue() {
        if(mathStudents.isEmpty() && biologyStudents.isEmpty()){
            return false;
        }
        if(mathStudents.isEmpty()) {
            queue.add(biologyStudents.poll());
            return true;
        }
        if(biologyStudents.isEmpty()) {
            queue.add(mathStudents.poll());
            return true;
        }
        double probability = Math.random();
        final double halfProbability = 0.5;
        if(probability > halfProbability) {
            queue.add(mathStudents.poll());
            return true;
        }
        else {
            queue.add(biologyStudents.poll());
            return true;
        }
    }
    public void run() {

        while(true) {
            if(queue.size() < maxQueueSize/2) {
                while(queue.size() < maxQueueSize) {
                    if(!addRandomStudentsToQueue()) {
                        return;
                    }
                }
            }
        }

    }
}
