package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of Task objects.
 * Supports adding, finding, and filtering tasks by status.
 * * @author Zamijah Shakeur-Tompkins
 */
public class TaskManager {
    private Map<String, Task> tasks;

    /**
     * Initializes a new TaskManager with an empty task collection.
     */
    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    /**
     * Adds a new task to the manager.
     * * @param task the Task object to add
     * @throws IllegalArgumentException if a task with the same ID already exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID detected.");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Locates a task by its unique ID.
     * * @param taskId the ID of the task to find
     * @return the Task object if found, or null otherwise
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Retrieves all tasks that match a specific status.
     * * @param status the status to filter by
     * @return a List of matching Task objects
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }
        return result;
    }
}