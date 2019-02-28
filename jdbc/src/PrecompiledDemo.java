import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrecompiledDemo {
public static void main(String[] args) {
	//? 
	String sql = "insert into person values(?,?,?)";
	Connection con=null;
	 try {
		con=JdbcFactory.getConnection();
		 PreparedStatement stmt=con.prepareStatement(sql);
		 //Replacing place-holder with date
		   stmt.setString(1,args[0]);
		   stmt.setInt(2,Integer.parseInt(args[1]));
		   stmt.setString(3,args[2]);
		     stmt.executeUpdate();//performing DML
		     System.out.println("recoed insert");
	} catch (NumberFormatException e) {
	
		e.printStackTrace();
	} catch (SQLException e) {
		System.out.println("record insertion failed");
		e.printStackTrace();
	}finally {
		if (con != null)
			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	    
}
}
