package lesson16;

import java.io.IOException;

public class SecondThread extends Thread {

    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            Thread.currentThread().setName("Второй поток");
            Logger log = new Logger(TypeMsg.WARN);
            String str = "Варн";
            do {
                log.writeLog(str);
            } while (LoggerRunner.isTime(startTime));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
