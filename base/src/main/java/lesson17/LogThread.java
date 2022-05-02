package lesson17;

import lesson16.Logger;
import lesson16.LoggerRunner;
import lesson16.enums.LogLevel;

import java.io.IOException;

public class LogThread implements Runnable {

    private LogLevel logLevel;

    public LogThread(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            Logger log = new Logger(logLevel);
            do {
                log.writeLog(logLevel.getName());
            } while (LoggerRunner.isTime(startTime));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}

