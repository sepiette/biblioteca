import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;


public class MainMenuTest {

    private PrintStream printStream;
    private MainMenu mainMenu;
    private BufferedReader reader;
    private Biblioteca biblioteca;
    private WelcomeMessage welcomeMessage;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        welcomeMessage = mock(WelcomeMessage.class);
        mainMenu = new MainMenu(printStream, reader, biblioteca, welcomeMessage);
    }

    @Test
    public void printMenu() {
        mainMenu.displayMenu();
        verify(printStream).println("Main Menu:");
    }

    @Test
    public void shouldPrintMenuOptions() {
        mainMenu.displayMenu();
        verify(printStream).println("Enter 0 for a list of books:");
    }

    @Test
    public void shouldPrintWelcomeMessageWhenStart() throws Exception {
        mainMenu.start();
        verify(welcomeMessage).displayWelcomeMessage();
    }

    @Test
    public void shouldListBooksWhenUserEntersOne() throws IOException {
        when(reader.readLine()).thenReturn("1");
    }


}