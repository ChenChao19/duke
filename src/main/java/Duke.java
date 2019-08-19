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
        List<String> list = new ArrayList<>();
        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (input.equals("bye")) break;
            else if (input.equals("list")) {
                if(list.isEmpty()) System.out.println("List is empty!");
                else { //list not empty
                    for(int i =  0 ; i < list.size(); i++) {
                        System.out.print(i + 1);
                        System.out.print(". ");
                        System.out.println(list.get(i));
                    }
                }
            } else {
                System.out.print("added: ");
                System.out.println(input);
                list.add(input);
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}