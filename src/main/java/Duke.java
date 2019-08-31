import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    static ArrayList<Task> list = new ArrayList<>();
    static Storage storage;
    static Ui ui;

    public static void main(String[] args) {
        storage = new Storage("D:/Desktop/duke/src/main/");
        ui = new Ui();
        storage.readingFile();
        ui.DukeInitialize();
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                String input = in.nextLine();
                if(input.equals("bye")) break;
                Parser.parse(input);
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
}