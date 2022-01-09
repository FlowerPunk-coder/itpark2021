package lesson18;

import java.io.*;

public class FileReaderRunner {

    public static void main(String[] args) {

        new Thread(() ->
            FileReaderRunner.fileToFiles(FileReaderRunner
                    .class
                    .getResourceAsStream("/text.txt"), "f:/test/text/text.txt")).start();
    }

    public static void fileToFiles(InputStream in, String path) {
        try (BufferedReader bR = new BufferedReader(new InputStreamReader((in)))) {
            String[] fullPath = path.split("\\.");
            int i = 1;
            while (bR.ready()) {
                FileWriter fW = new FileWriter(fullPath[0] + i + "." + fullPath[1]);
                fW.write(bR.readLine());
                fW.flush();
                fW.close();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
