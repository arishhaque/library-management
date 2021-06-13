package librarymanager.backend.dao;

import librarymanager.backend.builders.Book;
import librarymanager.backend.builders.BookBuilder;
import librarymanager.backend.builders.Shelf;
import librarymanager.backend.builders.ShelfBuilder;
import librarymanager.backend.dbconfig.DbConnectionSingleton;
import librarymanager.util.BookDetailsDto;

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
            con = DbConnectionSingleton.getInstance().getConnection();
            PreparedStatement ps=con.prepareStatement("select * from shelves",
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();

        }catch(Exception e){System.out.println(e);}

        List<Shelf> shelves = new ArrayList<>();
        while (rs.next()) {

            Shelf shelf = new ShelfBuilder(rs.getString("name"))
                    .setId(rs.getInt("id"))
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

            con = DbConnectionSingleton.getInstance().getConnection();
            PreparedStatement ps=con.prepareStatement("select * from books",
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();

        }catch(Exception e){System.out.println(e);}

        List<Book> books = new ArrayList<>();

        while (rs.next()) {

            Book book = new BookBuilder(rs.getString("name"))
                    .setIsbn(rs.getString("isbn"))
                    .addAvailability(rs.getString("is_available") != null && rs.getString("is_available")
                            .equalsIgnoreCase("true") ? true : false)
                    .addGenre(rs.getString("genre"))
                    .addRating(rs.getDouble("rating"))
                    .addQuantity(rs.getInt("quantity"))
                    .addAuthor(rs.getString("author"))
                    .addPublisher(rs.getString("publisher"))
                    .setShelfId(rs.getInt("shelf_no"))
                    .build();

            books.add(book);
        }
        if(con != null)
            con.close();

        return books;
    }

    public static List<BookDetailsDto> getBookDetails() throws SQLException {

        List<Book> books = getAllBooks();
        List<Shelf> shelves = getAllShelves();

        List<BookDetailsDto> bookDetailsList = new ArrayList<>();

        books.stream().forEach(book -> {

            shelves.stream().forEach(shelf -> {

                if(book.getShelfId().equals(shelf.getId())) {

                    BookDetailsDto bookDetailsDto = new BookDetailsDto.BookDetailsDtoBuilder(book.getIsbn())
                            .setName(book.getName())
                            .setGenre(book.getGenre())
                            .setRating(book.getRating())
                            .setAuthor(book.getAuthor())
                            .setPublisher(book.getPublisher())
                            .setAvailability(book.isAvailable())
                            .setShelf(shelf.getName())
                            .setLocation(shelf.getLocation())
                            .build();

                    bookDetailsList.add(bookDetailsDto);
                }
            });
        });
        return bookDetailsList;
    }

}
