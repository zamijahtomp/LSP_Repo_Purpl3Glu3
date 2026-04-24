package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract class representing the Template Method pattern for report generation.
 */
public abstract class Report {
    /**
     * The template method defining the fixed workflow.
     */
    public final void generateReport() {
        loadData();
        formatHeader();
        formatBody();
        formatFooter();
    }

    protected abstract void loadData();
    protected abstract void formatHeader();
    protected abstract void formatBody();
    protected abstract void formatFooter();
}