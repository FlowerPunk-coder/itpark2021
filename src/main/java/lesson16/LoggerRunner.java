package lesson16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class LoggerRunner {

    public static void main(String[] args) throws IOException, InterruptedException {

        long startTime = System.currentTimeMillis();
        FirstThread first = new FirstThread();
        SecondThread second = new SecondThread();
        ThirdThread third = new ThirdThread();
        first.start();
        second.start();
        third.start();
        Logger log = new Logger(TypeMsg.INFO);
        Logger log1 = new Logger(TypeMsg.ERROR);
        do {
            if (new Random().nextBoolean()) {
                log.writeLog("Тестовое сообщение");
            } else {
                log1.writeLog("Ошибка");
            }
        } while (checkTime(startTime));
        BufferedReader br = new BufferedReader(new FileReader(Logger.getPath()));
        while (br.ready()) {
            System.out.println(br.readLine());
        }
    }

    public static boolean checkTime(long startTime) throws InterruptedException {
        Thread.sleep(new Random().nextInt(5000));
        long stopTime = System.currentTimeMillis();
        return ((stopTime - startTime) / 1000) < 60;
    }
}
