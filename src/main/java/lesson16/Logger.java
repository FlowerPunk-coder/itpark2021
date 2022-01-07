package lesson16;

import lesson16.enums.LogLevel;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private LogLevel type;
    private static FileWriter fw;
    private static DateFormat df;
    private static String path = "F:/test/log.txt";

    static {
        try {
            fw = new FileWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    }

    public Logger(LogLevel type) {
        this.type = type;
    }

    public void writeLog(String msg) throws IOException {
        Date date = new Date();
        String str = "<" + df.format(date) + "> <" + this.type + "> <"
                + Thread.currentThread().getName() + "> <" + msg + ">\n";
        fw.write(str);
        fw.flush();
    }

    public static String getPath() {
        return path;
    }

    public static FileWriter getFileWriter() {
        return fw;
    }
}