package lesson16;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private TypeMsg type;
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

    public Logger(TypeMsg type) {
        this.type = type;
    }

    public void writeLog(String msg) throws IOException, InterruptedException {
        Date date = new Date();
        fw.append("<").append(df.format(date)).append(">  <").append(String.valueOf(this.type)).append(">  <")
                .append(Thread.currentThread().getName()).append(">  <").append(msg).append(">\n");
        fw.flush();
    }

    public static String getPath() {
        return path;
    }
}
