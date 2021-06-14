package librarymanager.backend.dao;


import librarymanager.backend.builders.LibrarianUser;
import librarymanager.backend.builders.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;


public class LibrarianDao implements GenericDao<User> {

	private static Connection con;
	
	public static int save(LibrarianUser librarianUser){
		int status=0;
		try{

			con = DbConfig.getInstance().getConnection();
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

	@Override
	public Optional<User> get(int id) {
		return Optional.empty();
	}

	@Override
	public List<User> getAll() {
		return null;
	}

	@Override
	public void save(User user) {

	}

	@Override
	public void update(User user, String[] params) {

	}

	@Override
	public void delete(int id) {

	}

	public static int remove(int id){
		int status=0;
		try{
			con = DbConfig.getInstance().getConnection();
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
			con = DbConfig.getInstance().getConnection();
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
			con = DbConfig.getInstance().getConnection();
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
			Connection con = DbConfig.getInstance().getConnection();
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
