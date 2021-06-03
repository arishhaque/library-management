package librarymanager;


import librarymanager.backend.Book;
import librarymanager.backend.CatalogueHCBuildTest;
import librarymanager.backend.User;
import librarymanager.frontend.LibraryMainView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;

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

        System.out.println("App started");
    }


    private static ConfigurableApplicationContext createApplicationContext(String[] args) {

        return new SpringApplicationBuilder(LibraryManagementApp.class)
                .headless(false)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("Begin test.");
        CatalogueHCBuildTest chcbt = new CatalogueHCBuildTest();

        System.out.println("\nBooks Test");
        for (Book book: chcbt.getCMP().getAllBooksByGenre("")) {
            System.out.println(book.getName());
        }

        System.out.println("\nUser Test");
        for (User u: chcbt.getCMP().validUsers) {
            System.out.println(u.getName());
        }
        System.out.println("\nEnd test.");
    }
}
