package librarymanager.backend.db;


import librarymanager.backend.Book;
import librarymanager.backend.BookBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

	private static Connection con;

	public static int save(Book book){

		int status = 0;
		try{

			con = DbConnectionSingleton.getInstance().createConnection();
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

	public static ResultSet getBooks() throws SQLException {

		ResultSet rs = null;
		int status = 0;
		try{
			Connection con = DbConnectionSingleton.getInstance().createConnection();
			PreparedStatement ps=con.prepareStatement("select * from books",
					ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();

		}catch(Exception e){System.out.println(e);}

		return rs;
	}

	public static List<String> getPaginatedBooks() throws SQLException {

		ResultSet rs = null;
		int status = 0;
		try{

			Connection con = DbConnectionSingleton.getInstance().createConnection();
			PreparedStatement ps=con.prepareStatement("select * from books",
					ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();

		}catch(Exception e){System.out.println(e);}

		List<String> list = new ArrayList<>();

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

			list.add(book.toString());
		}
		if(con != null)
			con.close();

		return list;
	}

	public static void closeDbConnection() {

		if(con !=null){

			try{
				con.close();
			}catch (SQLException e) { e.printStackTrace(); }
		}

	}
 }
