package librarymanager;


import librarymanager.frontend.LibraryMainView;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class LibraryManagementApp extends JFrame{

    static LibraryMainView frame;

    public static void main(String[] args) {

        ConfigurableApplicationContext context = createApplicationContext(args);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new LibraryMainView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("App started");
    }


    private static ConfigurableApplicationContext createApplicationContext(String[] args) {

        return new SpringApplicationBuilder(LibraryManagementApp.class)
                .headless(false)
                .run(args);
    }

}
