package lesson17;

import lesson16.Logger;
import lesson16.LoggerRunner;
import lesson16.enums.LogLevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorRunner {

    public static void main(String[] args) throws IOException, InterruptedException{

        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            executorService.execute(new LogThread(LogLevel.DEBUG));
            executorService.execute(new LogThread(LogLevel.WARN));
            executorService.execute(new LogThread(LogLevel.TRACE));
            executorService.execute(new LogThread(LogLevel.INFO));
            executorService.execute(new LogThread(LogLevel.ERROR));

            while (LoggerRunner.isTime(startTime));

            try (BufferedReader br = new BufferedReader(new FileReader(Logger.getPath()))) {
                while (br.ready()) {
                    System.out.println(br.readLine());
                }
            }
        } finally {
            executorService.shutdown();
        }
    }
}
