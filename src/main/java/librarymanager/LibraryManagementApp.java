package librarymanager;

import librarymanager.backend.Book;
import librarymanager.backend.CatalogueHCBuildTest;
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

        ConfigurableApplicationContext context = createApplicationContext(args);
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

        System.out.println("\\*Library Management System*/");
        CatalogueHCBuildTest chcbt = new CatalogueHCBuildTest();

        String genre = "Action";
        System.out.println("\nDisplay Books by Genre -> "+genre);
        for (Book book: chcbt.getCMP().getAllBooksByGenre(genre)) {
            System.out.println(book.getName() + ", Author: "+book.getAuthor());
        }

        System.out.println("\nDisplay Books by Rating");
        for (Book book: chcbt.getCMP().sortCatalogueByRating()) {
            System.out.println(book.getName() +", Rating: "+book.getRating());
        }

        String search = "First Blood";
        System.out.println("\nSearch Book: "+search);

        List<Book> books = chcbt.getCMP().searchBooks(search);
        if(books != null && !books.isEmpty()){

            System.out.println("Search Result");
            books.stream().forEach(book -> {

                System.out.println(book.getName());
            });
        }
        else {System.out.println("Book Search Results Not Found");}


        String searchAuthor = "Robert Ludlum";
        System.out.println("\nSearch Book By Author: "+searchAuthor);

        List<Book> booksByAuthor = chcbt.getCMP().searchBooksByAuthor(searchAuthor);
        if(booksByAuthor != null && !booksByAuthor.isEmpty()){

            System.out.println("Author Search Result");
            booksByAuthor.stream().forEach(book -> {

                System.out.println(book.getName() +", Author: "+searchAuthor);
            });
        }
        else {System.out.println("Search Results By Author Not Found");}

        /*
        System.out.println("\nUser Test");
        for (User u: chcbt.getCMP().validUsers) {
            System.out.println(u.getName());
        }
        System.out.println("\nEnd test.");

         */
    }
}
