public class Ui {

    void DukeInitialize() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    void ShowAdding(Task temp, TaskList list) {
        System.out.println("Got it, I have added this task:");
        System.out.println(temp.toString());
        System.out.println("Now you have " + list.getTask().size() + " tasks in the list.");
    }

    void ShowDelete(Task temp, TaskList list) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println(temp);
        System.out.println("Now you have " + list.getTask().size() + " tasks in the list.");
    }

    void ShowDone(int value, TaskList list) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[" + list.getTask().get(value - 1).getStatusIcon() + "] " + list.getTask().get(value - 1).description);
    }

    void ShowFind (String temp, TaskList list) throws DukeException {
        int index = 1;
        boolean flag = false;
        System.out.println(("Here are the matching tasks in your list:"));
        for (Task i : list.getTask()) {
            if (i.description.contains(temp)) {
                System.out.print(index + ".");
                System.out.println(i.toString());
                flag = true;
            }
            index++;
        }
        if (!flag) throw new DukeException("OOPS!!! Cannot find any Task containing " + temp);
    }

    void TaskEmptyError() throws DukeException {
        throw new DukeException("OOPS!!! The task cannot be is empty!");
    }

    void ListEmptyError() throws DukeException {
        throw new DukeException("OOPS!!! The list is empty!");
    }

    void TodoEmptyError() throws DukeException {
        throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
    }

    void DeadlineEmptyError() throws DukeException {
        throw new DukeException("OOPS!!! The description of a deadline cannot be empty.");
    }

    void EventEmptyError() throws DukeException {
        throw new DukeException("OOPS!!! The description of a event cannot be empty.");
    }

    void MeaningError() throws DukeException {
        throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    void IDoNotUnderStand() {
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    void DateFormatError() {
        System.out.println("Please enter in the format d/M/yyyy/ HHmm");
    }

    void DukeBye() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
