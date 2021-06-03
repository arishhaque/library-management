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
			//Connection con= DBConnect.getConnection();

			con = DbConnectionSingleton.getInstance().createConnection();
			PreparedStatement ps=con.prepareStatement("insert into books(isbn,name,author,publisher,quantity, rating) values(?,?,?,?,?,?)");
			ps.setString(1,book.getIsbn());
			ps.setString(2,book.getName());
			ps.setString(3,book.getAuthor());
			ps.setString(4,book.getPublisher());
			ps.setInt(5,book.getQuantity());
			ps.setDouble(6, book.getRating());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static ResultSet getBooks() throws SQLException {

		ResultSet rs = null;
		int status = 0;
		try{
			//Connection con= DBConnect.getConnection();

			Connection con = DbConnectionSingleton.getInstance().createConnection();
			PreparedStatement ps=con.prepareStatement("select * from books",
					ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			//con.close();
		}catch(Exception e){System.out.println(e);}

		return rs;
	}

	public static List<String> getPaginatedBooks() throws SQLException {

		ResultSet rs = null;
		int status = 0;
		try{
			//Connection con= DBConnect.getConnection();

			Connection con = DbConnectionSingleton.getInstance().createConnection();
			PreparedStatement ps=con.prepareStatement("select * from books",
					ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			//con.close();
		}catch(Exception e){System.out.println(e);}

		List<String> list = new ArrayList<>();

		while (rs.next()) {

			Book book = new BookBuilder(rs.getString("name"))
					.setIsbn(rs.getString("isbn"))
					.build();

			list.add(book.toString());
		}

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
