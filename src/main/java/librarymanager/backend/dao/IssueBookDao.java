package librarymanager.backend.dao;

import librarymanager.backend.dbconfig.DbConnectionSingleton;

import java.sql.*;


public class IssueBookDao {

	private static Connection con;

	public static boolean checkBook(String isbn){
		boolean status=false;
		try{

			con = DbConnectionSingleton.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement("select * from books where isbn=?");
			ps.setString(1,isbn);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static int save(String isbn,int studentid,String studentname,String studentcontact){
		int status=0;
		try{
			status= update(isbn);//updating quantity and issue
			if(status>0){

				con = DbConnectionSingleton.getInstance().getConnection();
				PreparedStatement ps=con.prepareStatement("insert into issuebooks(book_isbn,studentid,studentname,studentcontact) values(?,?,?,?)");
				ps.setString(1,isbn);
				ps.setInt(2,studentid);
				ps.setString(3,studentname);
				ps.setString(4,studentcontact);
				status=ps.executeUpdate();
			}

			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}


	public static int update(String isbn){
		int status=0;
		int quantity=0,issued=0;
		try{
			con = DbConnectionSingleton.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement("select quantity,issued from books where isbn=?");
			ps.setString(1,isbn);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				quantity=rs.getInt("quantity");
				issued=rs.getInt("issued");
			}
			if(quantity>0){
				PreparedStatement ps2=con.prepareStatement("update books set is_available=?,quantity=?,issued=? where isbn=?");
				ps2.setString(1, quantity - 1 <= 0 ? "false" : "true");
				ps2.setInt(2,quantity-1);
				ps2.setInt(3,issued+1);
				ps2.setString(4,isbn);

			status=ps2.executeUpdate();
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);

		}
		return status;
	}

	public static ResultSet getIssuedBooks() {

		ResultSet rs = null;
		int status = 0;
		try{

			con = DbConnectionSingleton.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement("select * from issuebooks",
					ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();

		}catch(SQLException e){
			System.out.println(e);
		}

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
