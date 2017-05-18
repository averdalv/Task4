package ua.training.view;

import ua.training.model.institute.BiologyInstitute;
import ua.training.model.institute.Institute;
import ua.training.model.institute.MathInstitute;

public class View {
    private static String INTERMEDIATE_STATE = "Intermediate state:";
    private static String START_STATE = "Start state:";
    private static String FINISH_STATE = "Finish state:";
    private static String MATH_INSTITUTE_NUM = "Number of students on math institute:";
    private static String BIOLOGY_INSTITUTE_NUM = "Number of students on biology institute:";
    private static String COMMON_INSTITUTE_NUM = "Number of students on common institute:";
    private static String SPACE = " ";
    private static String END_LINE = "\n";
    public void printMessages(String ...messages) {
        for(String message : messages) {
            System.out.print(message);
        }
    }

    public void printStartState() {
        printMessages(START_STATE,END_LINE);
    }

    public void printFinishState() {
        printMessages(FINISH_STATE,END_LINE);
    }

    public void printIntermediateState() {
        printMessages(INTERMEDIATE_STATE,END_LINE);
    }
    public void printInstituteNumber(Institute institute,String instituteString) {
        printMessages(instituteString,SPACE,Integer.toString(institute.getNumberOfStudents()),END_LINE);
    }
    public void printInstitutes(Institute[] institutes) {
        for(Institute institute : institutes) {
            if(institute instanceof BiologyInstitute) {
                printInstituteNumber(institute,BIOLOGY_INSTITUTE_NUM);
            }
            else if (institute instanceof MathInstitute) {
                printInstituteNumber(institute,MATH_INSTITUTE_NUM);
            }
            else {
                printInstituteNumber(institute,COMMON_INSTITUTE_NUM);
            }
        }
    }
}
