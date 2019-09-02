import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Duke {
    private Storage storage;
    private Ui ui;
    private TaskList list;

    public Duke() {
        ui = new Ui();
        storage = new Storage("D:/Desktop/duke/src/main/");
        storage.readingFile();
        list = new TaskList(storage.returnList());
    }

    public void run() {
        ui.DukeInitialize();
        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                if(in.hasNextLine()) {
                    String input = in.nextLine();
                    Parser P = new Parser(storage, ui, list);
                    if (input.equals("bye")) break;
                    P.parse(input);
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                ui.IDoNotUnderStand();
            } catch (DateTimeParseException e) {
                ui.DateFormatError();
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }
        ui.DukeBye();
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}