package lesson24;

import lesson24.db.DbUtils;
import lesson24.entity.FullBook;

import java.util.List;
import java.util.Scanner;

public class SearchBookRunner {

    private static final String EXIT_PHRASE = "exit";

    public static void main(String[] args) {

        System.out.printf("""
                Добро пожаловать в сервис поиска книг.
                Для поиска нужной книги введите ее название или автора.
                Для выхода из программы введите "%s".
                """, EXIT_PHRASE);
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final String text = scanner.nextLine();
            if (EXIT_PHRASE.equalsIgnoreCase(text)){
                return;
            }
            final List<FullBook> books = DbUtils.searchBookLikeTitleOrAuthor(text);
            System.out.println("Все возможные результаты:");
            System.out.println(books);
        }
    }
}
