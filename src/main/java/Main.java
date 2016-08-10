import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = initializeBiblioteca();
        biblioteca.start();
    }

    private static Biblioteca initializeBiblioteca() {
        PrintStream printStream = new PrintStream(System.out);
        Collection<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Into the Wild", "John Kraukaer", "1997", printStream));
        listOfBooks.add(new Book("Animal Farm", "George Orwell", "1934", printStream));

        return new Biblioteca(listOfBooks, initializeWelcomeMessage(printStream), initializeMainMenu(printStream), printStream);
    }

    private static MainMenu initializeMainMenu(PrintStream printStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return new MainMenu(printStream, reader);
    }

    private static WelcomeMessage initializeWelcomeMessage(PrintStream printStream) {
        return new WelcomeMessage(printStream);
    }
}
