import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private Collection<Book> listOfBooks;
    private Biblioteca biblioteca;
    private Book book;
    private PrintStream printStream;
    private WelcomeMessage welcomeMessage;
    private MainMenu mainMenu;

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

}
