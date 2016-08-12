import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;

public class Biblioteca {

    //cant instantiate a instance of Collection because its an interface
    private Collection<Book> listOfBooks;
    private BookCollection bookCollection;
    private PrintStream printStream;
    private BufferedReader reader;

    public Biblioteca(Collection<Book> listOfBooks, BookCollection bookCollection, PrintStream printStream, BufferedReader reader) {
        this.listOfBooks = listOfBooks;
        this.bookCollection = bookCollection;
        this.printStream = printStream;
        this.reader = reader;
    }

    public void listBooks() {
        bookCollection.print();
    }

    public void checkoutBook() {
        printStream.println("Enter Title of Book you wish to checkout:");
        String input = readUserInput();
        for(Book book: listOfBooks){
            if(book.isThisYourTitle(input)){
                listOfBooks.remove(book);
                break;
            }
        }

    }
    private String readUserInput(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
