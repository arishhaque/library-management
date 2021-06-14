package librarymanager.backend.dao;

import librarymanager.backend.builders.Book;
import librarymanager.backend.builders.BookBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDao implements GenericDao<Book> {

	private static Connection con;

	public static int add(Book book){

		int status = 0;
		try{

			con = DbConfig.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement("insert into books(isbn,name,genre,rating,author,publisher,quantity,shelf_no) values(?,?,?,?,?,?,?,?)");
			ps.setString(1,book.getIsbn());
			ps.setString(2,book.getName());
			ps.setString(3, book.getGenre());
			ps.setDouble(4, book.getRating());
			ps.setString(5,book.getAuthor());
			ps.setString(6,book.getPublisher());
			ps.setInt(7,book.getQuantity());
			ps.setInt(8, Integer.valueOf(book.getLocation()));

			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static ResultSet findAll() throws SQLException {

		ResultSet rs = null;
		int status = 0;
		try{
			Connection con = DbConfig.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement("select * from books",
					ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();

		}catch(Exception e){System.out.println(e);}

		return rs;
	}

	public static void closeDbConnection() {

		if(con !=null){

			try{
				con.close();
			}catch (SQLException e) { e.printStackTrace(); }
		}

	}

	@Override
	public void save(Book book) {

		try{

			con = DbConfig.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement("insert into books(isbn,name,genre,rating,author,publisher,quantity,shelf_no) values(?,?,?,?,?,?,?,?)");
			ps.setString(1,book.getIsbn());
			ps.setString(2,book.getName());
			ps.setString(3, book.getGenre());
			ps.setDouble(4, book.getRating());
			ps.setString(5,book.getAuthor());
			ps.setString(6,book.getPublisher());
			ps.setInt(7,book.getQuantity());
			ps.setInt(8, Integer.valueOf(book.getLocation()));

			con.close();
		}catch(Exception e){System.out.println(e);}
	}

	@Override
	public Optional<Book> get(int id) {

		ResultSet rs = null;
		int status = 0;
		Book book = null;
		try{
			Connection con = DbConfig.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement("select * from books where id=?",
					ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1,id);
			rs = ps.executeQuery();

			while (rs.next()) {

				book = new BookBuilder(rs.getString("name"))
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

			}

		}catch(Exception e){System.out.println(e);}

		return Optional.ofNullable(book);
	}

	@Override
	public List<Book> getAll() {

		ResultSet rs = null;
		int status = 0;
		List<Book> books = new ArrayList<>();
		try{
			Connection con = DbConfig.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement("select * from books",
					ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

			rs = ps.executeQuery();

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

		}catch(Exception e){System.out.println(e);}

		return books;
	}

	@Override
	public void update(Book book, String[] params) {

	}

	@Override
	public void delete(int id) {

		try {
			con = DbConfig.getInstance().getConnection();
			PreparedStatement ps = con.prepareStatement("delete from books where id=?");

			con.close();

		}catch (Exception e) { System.out.println(e);}
	}

}
