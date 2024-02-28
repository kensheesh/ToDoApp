package enums;

import model.Task;
import model.TaskManager;

public enum Priority {
    NEW("New") {
        @Override
        public void changePriorityToInProgress(Task task) {
            task.setPriorityObj(IN_PROGRESS);
            task.setPriority("InProgress");
            System.out.println("Task now in progress");
        }

        @Override
        public void changePriorityToDone(Task task) throws Exception {
            throw new Exception("Can't change priority to done!");
        }

        @Override
        public void changeDescription(Task task, String newDescription) {
            task.setDescription(newDescription);
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
        public void changePriorityToInProgress(Task task) throws Exception {
            throw new Exception("Can't change priority to InProgress");
        }

        @Override
        public void changePriorityToDone(Task task) {
            task.setPriorityObj(DONE);
            task.setPriority("Done");
            System.out.println("Task now is done");
        }

        @Override
        public void changeDescription(Task task, String newDescription) throws Exception {
            throw new Exception("Can't change description");
        }

        @Override
        public void deleteTask(Task task) throws Exception {
            throw new Exception("Can't delete task!");
        }
    },
    DONE("Done") {
        @Override
        public void changePriorityToInProgress(Task task) throws Exception {
            throw new Exception("Can't change priority to InProgress");
        }

        @Override
        public void changePriorityToDone(Task task) throws Exception {
            throw new Exception("Can't change priority to done!");
        }

        @Override
        public void changeDescription(Task task, String newDescription) throws Exception {
            throw new Exception("Can't change description");
        }

        @Override
        public void deleteTask(Task task) throws Exception {
            throw new Exception("Can't delete task!");
        }
    };

    private String value;

    Priority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract void changePriorityToInProgress(Task task) throws Exception;
    public abstract void changePriorityToDone(Task task) throws Exception;

    public abstract void changeDescription(Task task, String newDescription) throws Exception;

    public abstract void deleteTask(Task task) throws Exception;
}