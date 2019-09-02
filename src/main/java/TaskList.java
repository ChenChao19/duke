import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> DukeTaskList;

    public TaskList(ArrayList<Task> temp) {
        this.DukeTaskList = temp;
    }

    public ArrayList<Task> getTask() {
        return DukeTaskList;
    }

    public void addTask(Task temp) {
        DukeTaskList.add(temp);
    }

    public void deleteTask(int value) {
        DukeTaskList.remove(value);
    }
}
