import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This is the Deadline Class
 * inherits from Task Class
 * Has constructor and methods for the Deadline object
 */

public class Deadline extends Task {
    protected LocalDateTime by;

    /**
     * This constructor "Deadline" is used to construct the Deadline object when its created upon user input of "deadline xxx /by d/M/yyyy HHmm"
     * @param description This is a string of description of the task by the user
     * @param by This is a LocalDateTime of the deadline input by the user
     */

    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    /**
     * This method "getBy" is used to get the due date of the object
     * @return String This returns the due date of the object in a String
     */

    public String getBy() {
        return by.format(DateTimeFormatter.ofPattern("d/M/yyyy HHmm"));
    }

    /**
     * This method "toString" is used to return the relevant attributes to be printed
     * @return String This returns the relevant attributes to be printed in a String
     */

    public String toString() {
        return "[D]" + super.toString() + " (by: " + getBy() + ")";
    }
}
