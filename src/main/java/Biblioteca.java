import java.io.PrintStream;
import java.util.Collection;

public class Biblioteca {

    //cant instantiate a instance of Collection because its an interface
    private Collection<Book> listOfBooks;
    private PrintStream printStream;

    public Biblioteca(Collection<Book> listOfBooks, PrintStream printStream) {
        this.listOfBooks = listOfBooks;
        this.printStream = printStream;
    }

    public void listBooks() {
        for(Book book: listOfBooks) {
            book.printBookInformation();
        }
    }



}
