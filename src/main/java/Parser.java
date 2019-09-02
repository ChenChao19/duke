import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parser {

    private Storage storage;
    private Ui ui;
    private TaskList list;

    public Parser(Storage temp1, Ui temp2, TaskList temp3) {
        this.storage = temp1;
        this.ui = temp2;
        this.list = temp3;
    }

    void parse(String input) throws DukeException{
        if (input.length() == 0 | input.startsWith(" ")) {
            ui.TaskEmptyError();
        } else if (input.startsWith("list")) {
            if (list.getTask().isEmpty()) {
                ui.ListEmptyError();
            } else {
                for (int i = 0; i < list.getTask().size(); i++) {
                    System.out.println(i + 1 + "." + list.getTask().get(i));
                }
            }
        } else if (input.startsWith("todo")) {
            try {
                if (input.equals("todo"))
                    ui.TodoEmptyError();
                String[] split = input.split(" ", 2);
                if (split[1].startsWith(" ") || split[1].length() == 0)
                    ui.TodoEmptyError();
                Task todo_temp = new Todos(split[1]);
                list.getTask().add(todo_temp);
                storage.addToFile(todo_temp);
                ui.ShowAdding(todo_temp, list);
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        } else if (input.startsWith("event")) {
            try {
                if (input.equals("event"))
                    ui.EventEmptyError();
                String[] split = input.split(" ", 2); //remove event from the rest
                if (split[1].startsWith(" ") || split[1].length() == 0)
                    ui.EventEmptyError();
                String[] event_split = split[1].split(" /at "); //remove /at from the rest
                Task event_temp = new Event(event_split[0], event_split[1]);
                list.addTask(event_temp);
                storage.addToFile(event_temp);
                ui.ShowAdding(event_temp, list);
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        } else if (input.startsWith("deadline")) {
            if (input.equals("deadline"))
                ui.DeadlineEmptyError();
            String[] split = input.split(" ", 2);
            if (split[1].startsWith(" ") || split[1].length() == 0)
                ui.DeadlineEmptyError();
            String[] deadline_split = split[1].split(" /by ");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
            LocalDateTime formatDateTime = LocalDateTime.parse(deadline_split[1], formatter);
            Task deadline_temp = new Deadline(deadline_split[0], formatDateTime);

            list.addTask(deadline_temp);
            storage.addToFile(deadline_temp);
            ui.ShowAdding(deadline_temp, list);
        } else if (input.startsWith("done")) {
            String[] split = input.split(" ", 2);
            int value = Integer.parseInt(split[1]);
            list.getTask().get(value - 1).Done();
            storage.updateFile();
            ui.ShowDone(value, list);
        } else if (input.startsWith("delete")) {
            String[] split = input.split(" ", 2);
            int value = Integer.parseInt(split[1]);
            Task temp = list.getTask().get(value - 1);
            list.deleteTask(value - 1);
            storage.updateFile();
            ui.ShowDelete(temp, list);
        } else if (input.startsWith("find")) {
            String[] split = input.split(" ", 2);
            ui.ShowFind(split[1], list);
        } else {
            ui.MeaningError();
        }
    }
}
