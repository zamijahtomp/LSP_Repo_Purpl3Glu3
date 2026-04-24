package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete implementation for Student Reports.
 */
public class StudentReport extends Report {
    private String studentName;
    private double gpa;

    @Override
    protected void loadData() {
        this.studentName = "John Doe";
        this.gpa = 3.8;
    }

    @Override
    protected void formatHeader() {
        System.out.println("=== HEADER ===\nStudent Report");
    }

    @Override
    protected void formatBody() {
        System.out.println("\n=== BODY ===\nStudent Name: " + studentName + "\nGPA: " + gpa);
    }

    @Override
    protected void formatFooter() {
        System.out.println("\n=== FOOTER ===\nEnd of Student Report\n");
    }
}