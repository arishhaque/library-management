package librarymanager.frontend;

import librarymanager.backend.db.BookDao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CatalogueView extends JFrame {

    static CatalogueView frame;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new CatalogueView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CatalogueView() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        DefaultListModel listModel = new DefaultListModel();
        List<String> books = new ArrayList<>();
        try {
            books = BookDao.getPaginatedBooks();
        }
        catch (Exception e){

        }

        books.stream().forEach(b -> listModel.addElement(b.toString()));

        contentPane.add(new JList<Array>(listModel));

    }

}
