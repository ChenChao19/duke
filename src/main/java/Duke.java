import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * This is the Duke program
 * Takes in an input from the user and executes the command
 * result is shown as the output on the console
 *
 * @author Chen Chao
 * @version Phase 1
 * @since 2019-09-09
 */

public class Duke {
    private Storage storage;
    private Ui ui;
    private TaskList list;

    /**
     * This Constructor "Duke" instantiates the necessary data structures on startup
     */

    public Duke() {
        ui = new Ui();
        storage = new Storage("D:/Desktop/duke/src/main/");
        storage.readingFile();
        list = new TaskList(storage.returnList());
    }

    /**
     * This method "run" is used to continuously scan for user input
     * user input is passed into "Parser" to process the input to execute the corresponding action
     */

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