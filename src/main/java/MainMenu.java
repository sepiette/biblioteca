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
            if(result.equals("1")){
                biblioteca.listBooks();
            }
            else if(result.equals("2")){
                biblioteca.checkoutBook();
            }
            result = readUserInput();
        }
        printStream.println("Goodbye");
    }

    public String readUserInput() throws IOException {
        String str = reader.readLine();
        while (!str.equals("1") && !str.equals("2")&& (!str.equals("quit"))) {
            printStream.println("Select a Valid Option!");
            str = reader.readLine();
        }
        return str;
    }

    public void processUserInput() {
        /*Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("1", new ListBooksCommand());
        String input = readUserInput();
        if(commandMap.containsKey(input)) {
            Command command = commandMap.get(input);
            command.execute();
        }*/

    }




}

