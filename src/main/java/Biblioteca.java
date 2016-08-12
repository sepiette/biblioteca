import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Collection;

public class Biblioteca {

    //cant instantiate a instance of Collection because its an interface
    private Collection<Book> listOfBooks;
    private PrintStream printStream;
    private BufferedReader reader;

    public Biblioteca(Collection<Book> listOfBooks, PrintStream printStream) {
        this.listOfBooks = listOfBooks;
        this.printStream = printStream;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void listBooks() {
        for(Book book: listOfBooks) {
            book.printBookInformation();
        }
    }

    public void checkoutBook() {
        printStream.println("Enter Title of Book you wish to checkout:");
        listOfBooks.remove(0);
    }

    private void askUserForBookTitleToCheckout() {

    }
//    private String readUserInput(){
//        try {
//            return reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
