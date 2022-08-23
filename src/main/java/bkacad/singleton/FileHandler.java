package bkacad.singleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
    private static File file = null;
    private static FileHandler instance = new FileHandler();

    private FileHandler() {

    }

    public static FileHandler getDefaultInstance() throws IOException {
        if (file == null) {
            file = new File("C:\\java\\test.txt");
            // Kiểm tra nếu file chưa khởi tạo -> tạo mới
            if (!file.exists()) {
                file.createNewFile();
            }
        }
        return instance;
    }

    public static FileHandler getInstance(String pathFile) throws IOException {
        if (file == null) {
            file = new File(pathFile);
            // Kiểm tra nếu file chưa khởi tạo -> tạo mới
            if (!file.exists()) {
                file.createNewFile();
            }
        }
        return instance;
    }

    public String readFile() throws FileNotFoundException {
        Scanner myReader = new Scanner(file);
        StringBuffer buffer = new StringBuffer();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine() + "\n";
            buffer.append(data);
        }
        myReader.close();
        return buffer.toString();
    }

    public void writeFile(String content) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(content + "\n");
        fileWriter.close();
    }

    public void resetFile() throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("");
        fileWriter.close();
    }

}
