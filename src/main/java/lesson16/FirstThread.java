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
            String str = "Дебаг";
            do {
                log.writeLog(str);
            } while (LoggerRunner.checkTime(startTime));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
