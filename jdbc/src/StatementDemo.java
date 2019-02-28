
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {

	public static void main(String[] args) {
		String sql = "insert into person values('polo',31,'pune')"; 
		Connection con = null;
		
		try {
			con = JdbcFactory.getConnection();  // getting conn
			//
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql); // performing dml
			System.out.println("recoed inserted");
		} catch (SQLException e) {
			System.out.println("record insertion failed");
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
 