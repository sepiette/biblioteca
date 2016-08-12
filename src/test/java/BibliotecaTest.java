import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.Console;
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

    @Before
    public void setUp() throws Exception {
        listOfBooks = new ArrayList<>();
        book = mock(Book.class);
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        biblioteca = new Biblioteca(listOfBooks,printStream,reader);
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
    public void shouldPromptUserToCheckoutBook() throws Exception {
        listOfBooks.add(book);
        biblioteca.checkoutBook();
        verify(printStream).println("Enter Title of Book you wish to checkout:");
    }
    @Test
    public void shouldRemoveBookWhenUserChecksOut(){
        listOfBooks.add(book);
        biblioteca.checkoutBook();
        assertFalse(listOfBooks.contains(book));
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
    }
    //    @Test
//    public void shouldRemoveBookFromCollectionWhenCheckoutIsCalled() {
//        String str = new String();
//        when(book.isThisYourTitle(str)).thenReturn(true);
//        listOfBooks.add(book);
//        biblioteca.checkoutBook();
//        assertFalse(listOfBooks.contains(book));
//    }


}
