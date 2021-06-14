package librarymanager.backend.dao;

import librarymanager.backend.builders.Book;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ReturnBookDao implements GenericDao<Book> {

	private static Connection con;

	public static int returnBook(String isbn, int studentid) {

		int status = 0;
		try{

				con = DbConfig.getInstance().getConnection();
				PreparedStatement ps=con.prepareStatement("update issuebooks set returndate=? where book_isbn=? and studentid=?");
				ps.setDate(1, new Date(System.currentTimeMillis()));
				ps.setString(2,isbn);
				ps.setInt(3,studentid);
				status=ps.executeUpdate();

				if(status>0)
					status = update(isbn);

			if(con != null)
				con.close();
		}catch(Exception e){System.out.println(e);
		}

		return status;
	}


	public static int update(String isbn){

		int status=0;
		int quantity=0,issued=0;
		try{
			con = DbConfig.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement("select quantity,issued from books where isbn=?");
			ps.setString(1,isbn);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				quantity=rs.getInt("quantity");
				issued=rs.getInt("issued");
			}
			
			if(issued>0){
			PreparedStatement ps2=con.prepareStatement("update books set is_available=?,quantity=?,issued=? where isbn=?");
			ps2.setString(1, "true");
			ps2.setInt(2,quantity+1);
			ps2.setInt(3,issued-1);
			ps2.setString(4,isbn);
			
			status=ps2.executeUpdate();
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	@Override
	public Optional<Book> get(int id) {
		return Optional.empty();
	}

	@Override
	public List<Book> getAll() {
		return null;
	}

	@Override
	public void save(Book book) {

	}

	@Override
	public void update(Book book, String[] params) {

	}

	@Override
	public void delete(int id) {

	}
}
