package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete implementation for Course Reports.
 */
public class CourseReport extends Report {
    private String courseName;
    private int enrollment;

    @Override
    protected void loadData() {
        this.courseName = "CSCI 363";
        this.enrollment = 45;
    }

    @Override
    protected void formatHeader() {
        System.out.println("=== HEADER ===\nCourse Report");
    }

    @Override
    protected void formatBody() {
        System.out.println("\n=== BODY ===\nCourse: " + courseName + "\nEnrollment: " + enrollment);
    }

    @Override
    protected void formatFooter() {
        System.out.println("\n=== FOOTER ===\nEnd of Course Report\n");
    }
}