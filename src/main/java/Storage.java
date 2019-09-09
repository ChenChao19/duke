import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is the Storage Class
 * Saved data stored in TaskList
 * Retrieves data saved in Duke.txt
 * Repopulates TaskList with data retrieved from Duke.txt
 */

public class Storage {
    private String pathName;
    private ArrayList<Task> list = new ArrayList<>();


    /**
     * This Constructor "Storage" instantiates the necessary variables to be used in Class "Storage"
     * @param filePath This is the filePath to Duke.txt
     */
    public Storage(String filePath) {
        this.pathName = filePath;
    }

    /**
     * This method "returnList" is used to clone objects from TaskList to list
     * @return ArrayList<Task> This is the ArrayList of objects to be cloned to List
     */
    public ArrayList<Task> returnList() {
        return list;
    }

    /**
     * This method "writeFile" is used to write a String to Duke.txt
     * @param task This is the tasks from the user that will be saved in Duke.txt
     */
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

    /**
     * This method "updateFile" is used to update Duke.txt every time there is a change
     */
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


    /**
     * This method "readingFile" is used to read data from Duke.txt
     */
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
