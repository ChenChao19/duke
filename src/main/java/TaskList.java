import java.util.ArrayList;

/**
 * This is the TaskList Class
 * contains the TaskList for Duke as well as the constructors and methods for TaskList
 */
public class TaskList {
    protected ArrayList<Task> DukeTaskList;

    /**
     * This constructor "TaskList" is used to instantiate the attributes of the TaskList Object
     * @param temp This is a ArrayList<Task> that stores the tasks by the user
     */
    public TaskList(ArrayList<Task> temp) {
        this.DukeTaskList = temp;
    }

    /**
     * This method "getTask" is used to return the relevant attributes
     * @return ArrayList<Task> This returns the task list of the user
     */
    public ArrayList<Task> getTask() {
        return DukeTaskList;
    }

    /**
     * This method "addTask" is used to add Tasks into the list of tasks
     * @param temp This is a Task that is needed to be stored in the list of task
     */
    public void addTask(Task temp) {
        DukeTaskList.add(temp);
    }

    /**
     * This method "deleteTask" is used to delete Tasks from the list of tasks
     * @param value This is the index of the task to be deleted from the list of tasks
     */
    public void deleteTask(int value) {
        DukeTaskList.remove(value);
    }
}
