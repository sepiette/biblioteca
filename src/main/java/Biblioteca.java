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

    public void checkoutBook() {
        askUserForBookTitleToCheckout();
    }

    private void askUserForBookTitleToCheckout() {
        //ask user for book title to check out
        System.out.println("Please enter a book title to checkout");
        String bookTitle = reader.readLine();
        for(Book book: listOfBooks) {
            if(book.isThisYourTitle(bookTitle)) {
                listOfBooks.remove(book);
            }
        }
    }
}
