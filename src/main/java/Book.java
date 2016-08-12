import java.io.PrintStream;

public class Book {


    private final String title;
    private final String author;
    private final String year;
    private final PrintStream printStream;

    public Book(String title, String author, String year, PrintStream printStream) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.printStream = printStream;
    }

    public void printBookInformation() {
        printStream.println(title + " | " + author + " | " + year);
    }

    public boolean isThisYourTitle(String str) {
        return true;
    }
}
