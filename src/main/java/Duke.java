import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        List<Task> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int task_counter = 0;
        while (true) {
            try{
                String input = in.nextLine();
                if(input.length() == 0 | input.startsWith(" ")) throw new DukeException("☹ OOPS!!! The task cannot be is empty!");
                if(input.startsWith("bye")) {
                    break;
                } else if(input.startsWith("list")) {
                    if (list.isEmpty()) {
                        System.out.println("☹ OOPS!!! The list is empty!");
                    } else {
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println(i + 1 + "." + list.get(i));
                        }
                    }
                } else if(input.startsWith("todo")) {
                    try {
                        if (input.equals("todo")) throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                        String[] split = input.split(" ", 2);
                        if (split[1].startsWith(" ") || split[1].length() == 0) throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                        Task todo_temp = new Todos(split[1]);
                        list.add(todo_temp);
                        task_counter++;
                        System.out.println("Got it, I have added this task:");
                        System.out.println(todo_temp.toString());
                        System.out.println("Now you have " + task_counter + " tasks in the list.");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    }
                } else if(input.startsWith("event")) {
                    try {
                        if (input.equals("event")) throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
                        String[] split = input.split(" ", 2); //remove event from the rest
                        if (split[1].startsWith(" ") || split[1].length() == 0) throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
                        String[] event_split = split[1].split(" /at "); //remove /at from the rest
                        Task event_temp = new Event(event_split[0], event_split[1]);
                        list.add(event_temp);
                        task_counter++;
                        System.out.println("Got it, I have added this task:");
                        System.out.println(event_temp.toString());
                        System.out.println("Now you have " + task_counter + " tasks in the list.");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    }
                } else if(input.startsWith("deadline")) {
                    if (input.equals("deadline")) throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                    String[] split = input.split(" ", 2);
                    if (split[1].startsWith(" ") || split[1].length() == 0) throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                    String[] deadline_split = split[1].split(" /by ");
                    Task deadline_temp = new Deadline(deadline_split[0], deadline_split[1]);
                    list.add(deadline_temp);
                    task_counter++;
                    System.out.println("Got it, I have added this task:");
                    System.out.println(deadline_temp.toString());
                    System.out.println("Now you have " + task_counter + " tasks in the list.");
                } else if(input.startsWith("done")) {
                    String[] split = input.split(" ", 2);
                    int value = Integer.parseInt(split[1]);
                    list.get(value - 1).Done();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + list.get(value - 1).getStatusIcon() + "] " + list.get(value - 1).description);
                } else {
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}