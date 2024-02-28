package model;

import model.Task;

import java.util.ArrayList;
import java.util.List;
public class TaskManager {
    public static List<Task> tasks = new ArrayList<>();

    public static void deleteTask(Task task) {
        tasks.remove(task);
    }
    public void run() {

    }
}
