package lesson16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class LoggerRunner {

    public static void main(String[] args) throws IOException, InterruptedException {

        long startTime = System.currentTimeMillis();
        new FirstThread().start();
        new SecondThread().start();
        new ThirdThread().start();
        Logger log = new Logger(TypeMsg.INFO);
        Logger log1 = new Logger(TypeMsg.ERROR);
        do {
            if (new Random().nextBoolean()) {
                log.writeLog("Тестовое сообщение");
            } else {
                log1.writeLog("Ошибка");
            }
        } while (isTime(startTime));
        BufferedReader br = new BufferedReader(new FileReader(Logger.getPath()));
        while (br.ready()) {
            System.out.println(br.readLine());
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
