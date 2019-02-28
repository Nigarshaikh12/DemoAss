import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CollableDemo {

	public static void main(String[] args) {
		Connection con = null;

		try {
			con = JdbcFactory.getConnection();
			CallableStatement stmt = con.prepareCall("{call getAge(?,?)}");

			stmt.setString(1, "Mili");
			stmt.registerOutParameter(2, Types.INTEGER);
			stmt.execute();

			System.out.println("Age:" + stmt.getInt(2));
		} catch (SQLException e) {

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
