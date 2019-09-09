/**
 * This is the Event Class
 * inherits from Task Class
 * Has constructor and methods for the Event object
 */

public class Event extends Task {
    protected String at;

    /**
     * This constructor "Event" is used to construct the Event object when its created upon user input of "event xxx /at xxx"
     * @param description This is a string of description of the task by the user
     * @param at This is a string of timing of the event input by the user
     */

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * This method "toString" is used to return the relevant attributes to be printed
     * @return String This returns the relevant attributes to be printed in a String
     */

    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}