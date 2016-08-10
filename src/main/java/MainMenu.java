import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

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
        readUserInput();
    }

    public void displayMenu() {
        printStream.println("Please select one of the following options:");
        displayMenuOptions();
    }

    private void displayMenuOptions() {
        printStream.println("1 - List Books");
    }


    public void readUserInput() throws IOException {
        String str = reader.readLine();
        while (!str.equals("1") && (!str.equals("quit"))) {
            printStream.println("Select a Valid Option!");
            str = reader.readLine();
        }
        if (str.equals("quit")) printStream.println("Goodbye");
        else {
            biblioteca.listBooks();
        }
    }

    public void processUserInput() {
        /*Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("1", new ListBooksCommand());
        String input = readValidInput();
        if(commandMap.containsKey(input)) {
            Command command = commandMap.get(input);
            command.execute();
        }*/

    }
}

