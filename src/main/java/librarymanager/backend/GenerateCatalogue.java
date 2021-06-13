package librarymanager.backend;

import librarymanager.backend.builders.AdminUser;
import librarymanager.backend.builders.Book;
import librarymanager.backend.builders.Shelf;
import librarymanager.backend.dao.CatalogueDao;
import librarymanager.util.BookDetailsDto;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenerateCatalogue {

    CatalogueManagerProxy cmp;

    public GenerateCatalogue()  throws SQLException {

        this.cmp = new CatalogueManagerProxy(new AdminUser("admin", "admin@123"));
        this.buildCMPShelves();
        this.buildCMPBooks();

    }

    public CatalogueManagerProxy getCMP() {
        return this.cmp;
    }

    public void buildCMPShelves() throws SQLException {

        List<Shelf> shelves = CatalogueDao.getAllShelves();
        shelves.stream().forEach(shelf -> {

            this.cmp.addShelfToCatalogue(shelf);
        });

    }

    public void buildCMPBooks() throws SQLException {

        List<Book> books = CatalogueDao.getAllBooks();
        books.stream().forEach(book -> {

            this.cmp.addBookToCatalogue(book);
        });
    }

    public List<BookDetailsDto> getBookDetails() throws SQLException {

        List<BookDetailsDto> bookDetails = CatalogueDao.getBookDetails();
        bookDetails.sort(Comparator.comparing(BookDetailsDto :: getRating));
        Collections.reverse(bookDetails);
        return bookDetails;
    }
}
