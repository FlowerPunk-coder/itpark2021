package lesson18;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderRunner {

    public static void main(String[] args) {

        new Thread(() -> {
            try (BufferedReader bR = new BufferedReader(new InputStreamReader((FileReaderRunner.class.getResourceAsStream("/text.txt"))))) {
                String path = "F:/test/text/text";
                int i = 1;
                while (bR.ready()) {
                    FileWriter fW = new FileWriter(path + i + ".txt");
                    fW.write(bR.readLine());
                    fW.flush();
                    fW.close();
                    i++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
