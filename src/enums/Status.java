package enums;

import model.Task;
import model.TaskManager;

import java.util.Scanner;

public enum Status {
    NEW("New") {
        @Override
        public void changeStatusToInProgress(Task task) {
            task.setStatus(IN_PROGRESS);
            System.out.println("Task now in progress");
        }

        @Override
        public void changeStatusToDone(Task task) throws Exception {
            throw new Exception("Can't change priority to done!");
        }

        @Override
        public void changeDescription(Task task) {
            System.out.println("Please, enter new description:");
            String description = new Scanner(System.in).nextLine();
            task.setDescription(description);
            System.out.println("Task's description changed");
        }

        @Override
        public void deleteTask(Task task)  {
            TaskManager.deleteTask(task);
            System.out.println("Task deleted");
        }
    },
    IN_PROGRESS("InProgress") {
        @Override
        public void changeStatusToInProgress(Task task) throws Exception {
            throw new Exception("Can't change priority to InProgress");
        }

        @Override
        public void changeStatusToDone(Task task) {
            task.setStatus(DONE);
            System.out.println("Task now is done");
        }

        @Override
        public void changeDescription(Task task) throws Exception {
            throw new Exception("Can't change description");
        }

        @Override
        public void deleteTask(Task task) throws Exception {
            throw new Exception("Can't delete task!");
        }
    },
    DONE("Done") {
        @Override
        public void changeStatusToInProgress(Task task) throws Exception {
            throw new Exception("Can't change priority to InProgress");
        }

        @Override
        public void changeStatusToDone(Task task) throws Exception {
            throw new Exception("Can't change priority to done!");
        }

        @Override
        public void changeDescription(Task task) throws Exception {
            throw new Exception("Can't change description");
        }

        @Override
        public void deleteTask(Task task) throws Exception {
            throw new Exception("Can't delete task!");
        }
    };

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract void changeStatusToInProgress(Task task) throws Exception;
    public abstract void changeStatusToDone(Task task) throws Exception;

    public abstract void changeDescription(Task task) throws Exception;

    public abstract void deleteTask(Task task) throws Exception;
}