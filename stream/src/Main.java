import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.OptionalDouble;
public class Main {
    public static void main(String[] args) {

        /* Sum stream */
        System.out.print("SUM: ");
        Integer Sum = IntStream
                        .range(1,10000)
                        .filter(E -> E % 7 != 0 && E % 5 == 0 && E % 3 == 0)
                        .sum();

        System.out.println(Sum);

        /* Even numbers stream */

        System.out.println("First 100 even numbers: ");
        Stream
            .iterate(0,E -> E + 2)
            .filter(E -> E % 8 != 0)
            .limit(100)
            .forEach(System.out::println);

        // BOOKS STREAMS
        List <Book> books =  IntStream.range(0, 20)
                .mapToObj(B -> BookCreator.BookCreation())
                .collect(Collectors.toList());

        /* Alphabetic order */

        System.out.println("All books:");
        System.out.println(books);

        System.out.println("Books sorted by alphabetic order:");

        books
            .stream()
            .filter(E -> E.getPrice() < 100)
            .sorted(Comparator.comparing(Book::getName))
                .forEach(System.out::println);

        /* Name shorter than 5 chars */
        System.out.println("All books:");
        System.out.println(books);

        System.out.println("Books with shorter name than 5 chars");

        long count = books
            .stream()
            .filter(E -> E.getName().length() < 5)
            .count();

        System.out.println("Count: " + count);

        /* Average price of book in the list */


        System.out.println("All books:");
        System.out.println(books);

        OptionalDouble average = books
            .stream()
            .mapToInt(Book::getPrice)
            .average();

        System.out.println("Average price: " + (average.isPresent() ? average.getAsDouble() : "err"));

        /* Cheaper than 500 */

        System.out.println("All books:");
        System.out.println(books);

        boolean cheaper = books
                            .stream()
                            .anyMatch(E -> E.getPrice() > 500);

        System.out.println("Are all books cheaper than 500: " + (cheaper ? "no" : "yes"));

    }
}