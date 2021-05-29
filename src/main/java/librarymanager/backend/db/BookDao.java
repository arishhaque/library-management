package librarymanager.backend.db;


import java.sql.*;

public class BookDao {

	private static Connection con;

	public static int save(String callno,String name,String author,
						   String publisher,int quantity){

		int status = 0;
		try{
			//Connection con= DBConnect.getConnection();

			con = DbConnectionSingleton.getInstance().createConnection();
			PreparedStatement ps=con.prepareStatement("insert into books(callno,name,author,publisher,quantity) values(?,?,?,?,?)");
			ps.setString(1,callno);
			ps.setString(2,name);
			ps.setString(3,author);
			ps.setString(4,publisher);
			ps.setInt(5,quantity);
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

	public static void closeDbConnection() {

		if(con !=null){

			try{
				con.close();
			}catch (SQLException e) { e.printStackTrace(); }
		}

	}
 }
