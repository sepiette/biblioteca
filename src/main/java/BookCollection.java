import java.io.PrintStream;
import java.util.Collection;

public class BookCollection {
    private PrintStream printStream;
    private Collection<Book> books;

    public BookCollection(PrintStream printStream, Collection<Book> books) {

        this.printStream = printStream;
        this.books = books;
    }

    public void print() {
        if(!books.isEmpty()){
            for(Book book: books) {
                book.printBookInformation();
            }
        }
    }

    public void move() {

    }

    public boolean contains(Book book) {
        return books.contains(book);
    }
}
