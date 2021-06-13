package librarymanager.backend.dao;

import librarymanager.backend.builders.Book;
import librarymanager.backend.dbconfig.DbConnectionSingleton;

import java.sql.*;

public class BookDao {

	private static Connection con;

	public static int save(Book book){

		int status = 0;
		try{

			con = DbConnectionSingleton.getInstance().getConnection();
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
			Connection con = DbConnectionSingleton.getInstance().getConnection();
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
 }
