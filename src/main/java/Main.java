import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        Biblioteca biblioteca = initializeBiblioteca();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        WelcomeMessage welcomeMessage = new WelcomeMessage(printStream);
        MainMenu menu = new MainMenu(printStream, reader, biblioteca, welcomeMessage);
        menu.start();
    }

    private static Biblioteca initializeBiblioteca() {
        PrintStream printStream = new PrintStream(System.out);
        Collection<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Into the Wild", "John Kraukaer", "1997", printStream));
        listOfBooks.add(new Book("Animal Farm", "George Orwell", "1934", printStream));

        return new Biblioteca(listOfBooks, printStream);
    }

}
