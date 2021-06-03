package librarymanager.backend.db;

import librarymanager.backend.Book;
import librarymanager.backend.BookBuilder;
import librarymanager.backend.Shelf;
import librarymanager.backend.ShelfBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogueDao {

    private static Connection con;

    public static List<Shelf> getAllShelves() throws SQLException {

        ResultSet rs = null;

        try{
            Connection con = DbConnectionSingleton.getInstance().createConnection();
            PreparedStatement ps=con.prepareStatement("select * from shelves",
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();

        }catch(Exception e){System.out.println(e);}

        List<Shelf> shelves = new ArrayList<>();
        while (rs.next()) {

            Shelf shelf = new ShelfBuilder(rs.getString("name"))
                    .addGenre(rs.getString("genre"))
                    .addLocation(rs.getString("location"))
                    .build();

            shelves.add(shelf);
        }
        if(con != null)
            con.close();
        return shelves;
    }


    public static List<Book> getAllBooks() throws SQLException {

        ResultSet rs = null;
        try{

            Connection con = DbConnectionSingleton.getInstance().createConnection();
            PreparedStatement ps=con.prepareStatement("select * from books",
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();

        }catch(Exception e){System.out.println(e);}

        List<Book> list = new ArrayList<>();

        while (rs.next()) {

            Book book = new BookBuilder(rs.getString("name"))
                    .setIsbn(rs.getString("isbn"))
                    .addAvailability(rs.getString("is_available") != null && rs.getString("is_available")
                            .equalsIgnoreCase("true") ? true : false)
                    .addGenre(rs.getString("genre"))
                    .addRating(rs.getDouble("rating"))
                    .setQuantity(rs.getInt("quantity"))
                    .addAuthor(rs.getString("author"))
                    .addPublisher(rs.getString("publisher"))
                    .build();

            list.add(book);
        }
        if(con != null)
            con.close();

        return list;
    }


}
