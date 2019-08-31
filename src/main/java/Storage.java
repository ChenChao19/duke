import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Storage extends Duke {
    private static String pathName;

    public Storage(String filePath) {
        this.pathName = filePath;
    }

    void addToFile(Task task) {
        File saveFile = new File(pathName + "duke.txt");
        try {
            FileWriter fileWriter = new FileWriter(saveFile, true);
            fileWriter.write(task.toString() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void updateFile() {
        File saveFile = new File(pathName + "duke.txt");
        try{
            FileWriter fileWriter = new FileWriter(saveFile, false);
            for(Task task : list) {
                fileWriter.write(task.toString() + " \n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void readingFile(){
        File file = new File(pathName + "duke.txt");
        if(file.exists()) {
            try{
                List<String> temp = Files.lines(file.toPath()).collect(Collectors.toList());
                for(String string : temp) {
                    Task curr;
                    if (string.contains("[T]")) {
                        curr = new Todos(string.substring(7));
                    } else if (string.contains("[D]")) {
                        DateTimeFormatter temp_formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
                        LocalDateTime temp_LocalDateTime = LocalDateTime.parse(string.substring(string.indexOf("(by: ") + 5, string.indexOf(")", string.length() - 2)), temp_formatter);
                        curr = new Deadline(string.substring(7, string.indexOf("(by: ") - 1), temp_LocalDateTime);
                    } else { // contains "[E]"
                        curr = new Event(string.substring(7, string.indexOf("(at: ") - 1), string.substring(string.indexOf("(at: ") + 5, string.length() - 1));
                    }

                    if(string.contains("[✓]")) {
                        curr.Done();
                    }

                    list.add(curr);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
