package lesson16;

import java.io.IOException;

public class FirstThread extends Thread {

    public FirstThread() {
    }

    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            Thread.currentThread().setName("Первый поток");
            Logger log = new Logger(TypeMsg.DEBUG);
            String str = "дебаг";
            do {
                log.writeLog(str);
            } while (LoggerRunner.isTime(startTime));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
