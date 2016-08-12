import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class BookCollectionTest {

    private PrintStream printStream;
    private BookCollection list;
    private ArrayList<Book> books;
    private Book book;
    private BookCollection bookCollection;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        book =mock(Book.class);
        list = new BookCollection(printStream, books);
        bookCollection = new BookCollection(printStream,books);
    }


    @Test
    public void shouldPrintBookListOfLength1() throws Exception {
        books.add(book);
        bookCollection.print();
        verify(book).printBookInformation();

    }

//    @Test
//    public void shouldRemoveBookFromList() throws Exception {
//        books.add(book);
//        when(book.isThisYourTitle("title")).thenReturn(true);
//        bookCollection.move();
//        assertFalse(bookCollection.contains(book));
//    }
}