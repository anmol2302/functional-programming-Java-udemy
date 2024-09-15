package exercises;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Library {
    private String name;
    private List<Book> books;

    // Constructor
    public Library(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}

 class Book {
    private String title;
    private String author;
    private int publicationYear;

    // Constructor
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + publicationYear + ")";
    }
}

public class BookFlatMap {

    public static void main(String[] args) {

        List<Library> libraries = Arrays.asList(
                new Library("City Library", Arrays.asList(
                        new Book("Book A", "Author X", 2021),
                        new Book("Book B", "Author Y", 2021),
                        new Book("Book C", "Author Z", 2020)
                )),
                new Library("County Library", Arrays.asList(
                        new Book("Book D", "Author X", 2021),
                        new Book("Book E", "Author W", 2019),
                        new Book("Book F", "Author Z", 2020)
                )),
                new Library("State Library", Arrays.asList(
                        new Book("Book G", "Author X", 2018),
                        new Book("Book H", "Author W", 2019),
                        new Book("Book I", "Author Y", 2021)
                ))
        );

        /**
         *
         * Flatten the list of books from all libraries into a single stream of Book objects.
         * Group these books by their publication year.
         * Calculate the average number of books published per year for each year.
         * Sort the publication years in ascending order and print each year with its corresponding average number of books
         */


        System.out.println(libraries.stream().flatMap(lib -> lib.getBooks().stream())
                        .map(book -> book.getTitle())
                        .sorted()
                .collect(Collectors.toList()));

        System.out.println(
                libraries.stream().flatMap(lib -> lib.getBooks().stream())
                        .collect(Collectors.groupingBy(Book::getPublicationYear))
        );

        System.out.println(libraries.stream().flatMap(library -> library.getBooks().stream())
                .collect(Collectors.groupingBy(Book::getPublicationYear, Collectors.counting())).entrySet()
                .stream().collect(Collectors.toMap(Map.Entry::getKey, val -> (double) val.getValue()/libraries.size() ))
        );




    }
}
