/**
 * This is the Task Class
 * Has constructor and methods for the Task object
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * This constructor "Task" is used to instantiate the attributes of the Task Object
     * @param description This is a string of description of the task by the user
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * This method "toString" is used to return the relevant attributes to be printed
     * @return String This returns the relevant attributes to be printed in a String
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * This method "Done" is used to mark the Task as done upon completion of the task
     * changes the isDone attribute to true
     */
    public void Done() {
        isDone = true;
    }

    /**
     * This method "getStatusIcon" is used to get the tick or cross icon based on if the task is done or not
     * @return String This returns the icon
     */
    public String getStatusIcon(){
        return (isDone ? "\u2713" : "\u2718");
    }
}