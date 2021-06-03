package librarymanager;

import librarymanager.backend.Book;
import librarymanager.backend.GenerateCatalogue;
import librarymanager.backend.db.BookDetailsDto;
import librarymanager.frontend.LibraryMainView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@SpringBootApplication
public class LibraryManagementApp extends JFrame implements CommandLineRunner {

    static LibraryMainView frame;

    public static void main(String[] args) {

        createApplicationContext(args);
        EventQueue.invokeLater(() -> {
            try {
                frame = new LibraryMainView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    private static ConfigurableApplicationContext createApplicationContext(String[] args) {

        return new SpringApplicationBuilder(LibraryManagementApp.class)
                .headless(false)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n");
        System.out.println("\\*     Library Management System     */");

        GenerateCatalogue gc = new GenerateCatalogue();

        System.out.println("\nTop Rated Books");
        List<BookDetailsDto> bookDetails = gc.getBookDetails();
        bookDetails.stream().forEach(obj -> {

            System.out.println("Title: " +obj.getName() + ", Genre: " + obj.getGenre() + ", Rating: " + obj.getRating() + "\n"
                    +"Author: "+ obj.getAuthor() +", Publisher: "+obj.getPublisher() + ", Availability: " +obj.isAvailable() + "\n"
                    + "Location: " +obj.getLocation() + ", Shelf: "+obj.getShelf());

            System.out.println();
        });

        String genre = "Action";
        System.out.println("\nTop Rated Books by Genre -> "+genre);
        for (Book book: gc.getCMP().getAllBooksByGenre(genre)) {
            System.out.println("Title: " +book.getName() + ", Author: "+book.getAuthor());
        }

        String search = "Treasure";
        System.out.println("\nSearch Book: "+search);

        List<Book> books = gc.getCMP().searchBooks(search);
        if(books != null && !books.isEmpty()){

            books.stream().forEach(book -> {

                System.out.println("Title: " +book.getName()+ ", Author: "+book.getAuthor());
            });
        }
        else {System.out.println("Book Search Results Not Found");}


        String searchAuthor = "Robert";
        System.out.println("\nSearch Book By Author: "+searchAuthor);

        List<Book> booksByAuthor = gc.getCMP().searchBooksByAuthor(searchAuthor);
        if(booksByAuthor != null && !booksByAuthor.isEmpty()){

            booksByAuthor.stream().forEach(book -> {

                System.out.println(book.getName() +", Author: "+book.getAuthor());
            });
        }
        else {System.out.println("Search Results By Author Not Found");}

    }
}
