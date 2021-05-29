package librarymanager.backend.db;


import java.sql.*;
public class LibrarianDao {

	private static Connection con;
	
	public static int save(String name,String password,String email,String address,String city,String contact){
		int status=0;
		try{

			con = DbConnectionSingleton.getInstance().createConnection();
			PreparedStatement ps=con.prepareStatement("insert into librarian(name,password,email,address,city,contact) values(?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,address);
			ps.setString(5,city);
			ps.setString(6,contact);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			con = DbConnectionSingleton.getInstance().createConnection();
			PreparedStatement ps=con.prepareStatement("delete from librarian where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			con = DbConnectionSingleton.getInstance().createConnection();
			PreparedStatement ps=con.prepareStatement("select * from librarian where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}


	public static ResultSet getLibrarians() {

		ResultSet rs = null;
		try {
			Connection con = DbConnectionSingleton.getInstance().createConnection();
			PreparedStatement ps = con.prepareStatement("select * from librarian", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
