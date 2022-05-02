package lesson16;

import lesson16.enums.LogLevel;

import java.io.IOException;

public class LogThread extends Thread {

    private LogLevel logLevel;

    public LogThread(String name, LogLevel logLevel) {
        setName(name);
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
