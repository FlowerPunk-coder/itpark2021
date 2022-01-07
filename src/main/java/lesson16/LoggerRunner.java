package lesson16;

import lesson16.enums.LogLevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoggerRunner {

    public static void main(String[] args) throws IOException, InterruptedException {

        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            executorService.execute(new LogThread(LogLevel.DEBUG));
            executorService.execute(new LogThread(LogLevel.WARN));
            executorService.execute(new LogThread(LogLevel.TRACE));
            executorService.execute(new LogThread(LogLevel.INFO));
            executorService.execute(new LogThread(LogLevel.ERROR));

            while (isTime(startTime));

            try (BufferedReader br = new BufferedReader(new FileReader(Logger.getPath()))) {
                while (br.ready()) {
                    System.out.println(br.readLine());
                }
            }
        } finally {
            executorService.shutdown();
            Logger.getFileWriter().close();
        }
    }

    public static boolean isTime(long startTime) throws InterruptedException {
        Thread.sleep(new Random().nextInt(5000));
        long stopTime = System.currentTimeMillis();
        if (((stopTime - startTime) / 1000) >= 60) {
            return false;
        }
        return true;
    }
}
