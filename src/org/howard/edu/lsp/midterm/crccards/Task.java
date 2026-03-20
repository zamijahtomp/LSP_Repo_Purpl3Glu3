package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a single task in the Task Management System.
 * Stores information about the task's ID, description, and status.
 * * @author Zamijah Shakeur-Tompkins
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a new Task with the specified ID and description.
     * The default status is set to "OPEN".
     * * @param taskId the unique identifier for the task
     * @param description a brief description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /** @return the unique task ID */
    public String getTaskId() { return taskId; }

    /** @return the task description */
    public String getDescription() { return description; }

    /** @return the current status of the task */
    public String getStatus() { return status; }

    /**
     * Updates the task status. Valid statuses are OPEN, IN_PROGRESS, and COMPLETE.
     * If an invalid status is provided, it is set to UNKNOWN.
     * * @param status the new status to set
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns a string representation of the task.
     * Format: taskId description [status]
     * * @return formatted task string
     */
    @Override
    public String toString() {
        return String.format("%s %s [%s]", taskId, description, status);
    }
}