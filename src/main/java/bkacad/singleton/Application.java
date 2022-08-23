package bkacad.singleton;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            FileHandler fileHandler = FileHandler.getInstance("C:\\java\\design_pattern.txt");
            in = new Scanner(System.in);
            int option;
            do {
                System.out.println("----MENU----");
                System.out.println("1.Nhập nội dung file");
                System.out.println("2.Xem nội dung file");
                System.out.println("3.Reset file");
                System.out.println("4.Thoát");
                option = Integer.parseInt(in.nextLine());

                switch (option) {
                    case 1:
                        System.out.print("Nhập: ");
                        String input = in.nextLine();
                        fileHandler.writeFile(input);
                        break;
                    case 2:
                        String content = fileHandler.readFile();
                        System.out.println("Nội dung: " + content);
                        break;
                    case 3:
                        fileHandler.resetFile();
                        break;

                    default:
                        if(option == 4){
                            return;
                        }
                        System.out.println("Nhập lại lựa chọn!!!");
                        break;
                }
            }
            while (option != 4);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) {
                in.close();
            }
        }

    }
}
