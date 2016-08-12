import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private Collection<Book> listOfBooks;
    private Biblioteca biblioteca;
    private Book book;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        listOfBooks = new ArrayList<>();
        book = mock(Book.class);
        printStream = mock(PrintStream.class);
        biblioteca = new Biblioteca(listOfBooks,printStream);
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        biblioteca.listBooks();
        verifyZeroInteractions(book);
    }

    @Test
    public void shouldPrintOneBookWhenThereIsOneBook() {
        listOfBooks.add(book);
        biblioteca.listBooks();
        verify(book).printBookInformation();
    }

    @Test
    public void shouldPrintMultipleBooksWhenThereAreMultipleBooks() {
        listOfBooks.add(book);
        listOfBooks.add(book);
        listOfBooks.add(book);
        biblioteca.listBooks();
        verify(book, times(3)).printBookInformation();
    }

    @Test
    public void shouldRemoveBookFromCollectionWhenCheckoutIsCalled() {
        String str = new String();
        when(book.isThisYourTitle(str)).thenReturn(true);
        listOfBooks.add(book);
        biblioteca.checkoutBook(str);
        assertFalse(listOfBooks.contains(book));
    }


}
