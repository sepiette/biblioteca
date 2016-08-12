
public class ListBooksCommand implements Command {

    private Biblioteca biblioteca;

    public ListBooksCommand(Biblioteca biblioteca) {

        this.biblioteca = biblioteca;
    }

    public void execute() {
        biblioteca.listBooks();
    }
}
