public class CheckoutBooksCommand implements Command {
    private Biblioteca biblioteca;

    public CheckoutBooksCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    @Override
    public void execute() {
        biblioteca.checkoutBook();
    }
}
