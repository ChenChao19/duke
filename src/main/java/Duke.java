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
        label:
        while (true) {
            String input = in.nextLine();
            String[] split = input.split(" ", 2);
            switch (split[0]) {
                case "bye":
                    break label;
                case "list":
                    if (list.isEmpty()) System.out.println("List is empty!");
                    else { //list not empty
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println(i + 1 + "." + list.get(i));
                            //System.out.print(i + 1 + ".[" + list.get(i).getStatusIcon() + "] ");
                            //System.out.println(list.get(i).description);
                        }
                    }
                    break;
                case "todo":
                    Task todo_temp = new Todos(split[1]);
                    list.add(todo_temp);
                    task_counter++;
                    System.out.println("Got it, I have added this task:");
                    System.out.println(todo_temp.toString());
                    System.out.println("Now you have " + task_counter + " tasks in the list.");
                    break;
                case "event":
                    String[] event_split = split[1].split(" /at ");
                    Task event_temp = new Event(event_split[0], event_split[1]);
                    list.add(event_temp);
                    task_counter++;
                    System.out.println("Got it, I have added this task:");
                    System.out.println(event_temp.toString());
                    System.out.println("Now you have " + task_counter + " tasks in the list.");
                    break;
                case "deadline":
                    String[] deadline_split = split[1].split(" /by ");
                    Task deadline_temp = new Deadline(deadline_split[0], deadline_split[1]);
                    list.add(deadline_temp);
                    task_counter++;
                    System.out.println("Got it, I have added this task:");
                    System.out.println(deadline_temp.toString());
                    System.out.println("Now you have " + task_counter + " tasks in the list.");
                    break;
                 case "done":
                    int value = Integer.parseInt(split[1]);
                    list.get(value - 1).Done();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + list.get(value - 1).getStatusIcon() + "] " + list.get(value - 1).description);
                    break;
                default:
                    System.out.print("added: ");
                    System.out.println(input);
                    Task temp = new Task(input);
                    list.add(temp);
                    break;
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}