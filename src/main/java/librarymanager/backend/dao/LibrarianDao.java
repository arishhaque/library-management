package librarymanager.backend.dao;


import librarymanager.backend.builders.LibrarianUser;
import librarymanager.backend.dbconfig.DbConnectionSingleton;

import java.sql.*;


public class LibrarianDao {

	private static Connection con;
	
	public static int save(LibrarianUser librarianUser){
		int status=0;
		try{

			con = DbConnectionSingleton.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement("insert into librarian(name,password,email,address,contact,is_admin) values(?,?,?,?,?,?)");
			ps.setString(1,librarianUser.getName());
			ps.setString(2,librarianUser.getPassword());
			ps.setString(3,librarianUser.getEmail());
			ps.setString(4,librarianUser.getAddress());
			ps.setString(5,librarianUser.getContact());
			ps.setString(6, String.valueOf(librarianUser.hasAdminAccess()));
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static int delete(int id){
		int status=0;
		try{
			con = DbConnectionSingleton.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement("delete from librarian where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}


	public static boolean isAdmin(String name,String password){
		boolean status=false;
		try{
			con = DbConnectionSingleton.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement("select is_admin from librarian where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			con = DbConnectionSingleton.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement("select * from librarian where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static ResultSet findAll() {

		ResultSet rs = null;
		try {
			Connection con = DbConnectionSingleton.getInstance().getConnection();
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