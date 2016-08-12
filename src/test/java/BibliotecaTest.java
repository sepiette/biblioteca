import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private Collection<Book> listOfBooks;
    private Biblioteca biblioteca;
    private Book book;
    private PrintStream printStream;
    private BufferedReader reader;
    private BookCollection bookCollection;

    @Before
    public void setUp() throws Exception {
        bookCollection = mock(BookCollection.class);
        book = mock(Book.class);
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        listOfBooks = new ArrayList<Book>();
        biblioteca = new Biblioteca(listOfBooks, bookCollection,printStream,reader);
    }

    @Test
    public void shouldListBooksWhenLibraryRequestsBookList() {
        biblioteca.listBooks();
        verify(bookCollection).print();
    }

    @Test
    public void shouldPromptUserToCheckoutBook() throws Exception {
        listOfBooks.add(book);
        biblioteca.checkoutBook();
        verify(printStream).println("Enter Title of Book you wish to checkout:");
    }

    @Test
    public void shouldStillContainBookWhenBook1Removed() throws Exception {
        Book book1 = mock(Book.class);
        when(reader.readLine()).thenReturn("Book Title","Book Title");
        when(book1.isThisYourTitle("Book Title")).thenReturn(true);
        listOfBooks.add(book);
        listOfBooks.add(book1);
        biblioteca.checkoutBook();
        assertTrue(listOfBooks.contains(book));
        assertFalse(listOfBooks.contains(book1));
    }




}
