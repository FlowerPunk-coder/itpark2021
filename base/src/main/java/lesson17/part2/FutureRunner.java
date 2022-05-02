package lesson17.part2;


import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class FutureRunner {

    public static void main(String[] args) {

        List<Integer> values = IntStream.range(0, 1_000_000).boxed().map(i -> new Random().nextInt(1_000_000)).toList();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture<String> futureMin = CompletableFuture.supplyAsync(() -> values.stream()
                    .min(Comparator.naturalOrder()).orElse(-1))
                    .thenApplyAsync(min -> ("Минимальное значение равно " + min), executorService);

            CompletableFuture<String> futureMax = CompletableFuture.supplyAsync(() -> values.stream()
                    .max(Comparator.naturalOrder()).orElse(-1))
                    .thenApplyAsync(max -> ("Максимальное значение равно " + max), executorService);

            CompletableFuture<String> futureAvg = CompletableFuture.supplyAsync(() -> values.stream()
                    .mapToInt(Integer::intValue)
                    .average().orElse(-1))
                    .thenApplyAsync(avg -> ("Среднее арифметическое значение " + avg), executorService);

            CompletableFuture.allOf(futureMin, futureMax, futureAvg).get();
            System.out.println(futureMin.get());
            System.out.println(futureMax.get());
            System.out.println(futureAvg.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

}
