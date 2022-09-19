import java.util.Random;

class BookCreator{
    public static Book BookCreation() {
        Random random=new Random();

        String bookName = random
                            .ints('a','z')
                            .limit(random.nextInt( 10 - 2) + 2)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint,StringBuilder::append)
                            .toString();

        return new Book(bookName,random.nextInt( 550 - 10) + 10);


    }
}
