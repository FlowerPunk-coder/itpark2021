package lesson16;

import java.io.IOException;

public class ThirdThread extends Thread {

    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            Thread.currentThread().setName("Третий поток");
            Logger log = new Logger(TypeMsg.TRACE);
            String str = "Трайс";
            do {
                log.writeLog(str);
            } while (LoggerRunner.checkTime(startTime));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
