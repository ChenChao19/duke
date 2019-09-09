/**
 * This is the ToDo Class
 * inherits from Task Class
 * Has constructor and methods for the ToDo object
 */
public class Todos extends Task {


    /**
     * This constructor "ToDo" is used to construct the ToDo object when its created upon user input of "todo xxx"
     * @param description This is a string of description of the task by the user
     */
    public Todos(String description) {
        super(description);
    }

    /**
     * This method "toString" is used to return the relevant attributes to be printed
     * @return String This returns the relevant attributes to be printed
     */
    public String toString() {
        return "[T]" + super.toString();
    }
}