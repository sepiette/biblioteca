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
    private final Map<String, Command> commandMap;


    public MainMenu(PrintStream printStream, BufferedReader reader, Biblioteca biblioteca, WelcomeMessage welcomeMessage) {
        this.printStream = printStream;
        this.reader = reader;
        this.biblioteca = biblioteca;
        this.welcomeMessage = welcomeMessage;
        commandMap = new HashMap<>();
        initializeCommandMap(commandMap);
    }

    private void initializeCommandMap(Map<String, Command> commandMap) {
        commandMap.put("1", new ListBooksCommand(biblioteca));
        commandMap.put("2", new CheckoutBooksCommand(biblioteca));

    }

    public void start() throws IOException {
        welcomeMessage.displayWelcomeMessage();
        displayMenu();
        executeMenuOptions();
    }

    public void displayMenu() {
        printStream.println("Please select one of the following options:");
        displayMenuOptions();
    }

    private void displayMenuOptions() {

        printStream.println("1 - List Books");
        printStream.println("2 - Checkout Books");
    }

    public void executeMenuOptions() throws IOException {
        String result = readUserInput();
        while(!result.equals("quit")) {
            processUsersOption(result);
            result = readUserInput();
        }
        printStream.println("Goodbye");
    }

    private void processUsersOption(String result) {

        if(commandMap.containsKey(result)) {
            Command command = commandMap.get(result);
            command.execute();
        }
//        if(result.equals("1")){
//            biblioteca.listBooks();
//        }
//        else if(result.equals("2")){
//            biblioteca.checkoutBook();
//        }
    }

    public String readUserInput() throws IOException {
        String str = reader.readLine();
        while (!str.equals("1") && !str.equals("2")&& (!str.equals("quit"))) {
            printStream.println("Select a Valid Option!");
            str = reader.readLine();
        }
        return str;
    }

}

