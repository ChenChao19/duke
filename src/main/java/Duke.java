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
        while (true) {
            String input = in.nextLine();
            Task temp = new Task(input);
            if (input.equals("bye")) break;
            else if (input.equals("list")) {
                if (list.isEmpty()) System.out.println("List is empty!");
                else { //list not empty
                    for (int i = 0; i < list.size(); i++) {
                        System.out.print(i + 1);
                        System.out.print(".[");
                        System.out.print(list.get(i).getStatusIcon());
                        System.out.print("] ");
                        System.out.println(list.get(i).description);
                    }
                }
            } else if (input.charAt(0) == 'd' && input.charAt(1) == 'o' && input.charAt(2) == 'n' && input.charAt(3) == 'e') {
                String[] split = input.split(" ");
                int value = Integer.parseInt(split[1]);
                list.get(value - 1).Done();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[" + list.get(value - 1).getStatusIcon() + "] " + list.get(value - 1).description);
            } else {
                System.out.print("added: ");
                System.out.println(input);
                list.add(temp);
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}