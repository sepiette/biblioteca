import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class MainMenu {

    private PrintStream printStream;
    private BufferedReader reader;
    private final Biblioteca biblioteca;
    private final WelcomeMessage welcomeMessage;


    public MainMenu(PrintStream printStream, BufferedReader reader, Biblioteca biblioteca, WelcomeMessage welcomeMessage) {
        this.printStream = printStream;
        this.reader = reader;
        this.biblioteca = biblioteca;
        this.welcomeMessage = welcomeMessage;
    }

    public void start() throws IOException {
        welcomeMessage.displayWelcomeMessage();
        displayMenu();
        readAndProcessUserInput();
    }

    public void displayMenu() {
        printStream.println("Please select one of the following options:");
        displayMenuOptions();
    }

    private void displayMenuOptions() {
        printStream.println("1 - List Books");
    }


    public void readAndProcessUserInput() throws IOException {
        String str = reader.readLine();
        if (str.equals("1"))
            biblioteca.listBooks();
    }
}

