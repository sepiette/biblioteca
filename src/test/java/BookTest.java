import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    private Book book;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        book = new Book("Title", "author", "year", printStream);
    }

    @Test
    public void shouldPrintBookTitleWhenPrintBookInformationIsCalled() {
        book.printBookInformation();
        verify(printStream).println("Title | author | year");
    }

    @Test
    public void shouldReturnTrueWhenTitleisValid(){
        assertTrue(book.isThisYourTitle("Title"));
    }

    @Test
    public void shouldReturnFalseWhenTitleisNotValid() throws Exception {
        assertFalse(book.isThisYourTitle("Wrong Title"));
    }
}
