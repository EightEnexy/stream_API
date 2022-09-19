import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;

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
            .iterate(1,E -> E + 1)
            .filter(E -> E % 2 == 0 && E % 8 != 0)
            .limit(100)
            .forEach(System.out::println);


    }
}