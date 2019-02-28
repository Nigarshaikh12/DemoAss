import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class ConnectionDemo {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = null;

		try {
			/*
			 * Class.forName("oracle.jdbc.OracleDriver"); con =
			 * DriverManager.getConnection(url, "NP3022", "NigarPrachi");
			 */
			con = JdbcFactory.getConnection();
			System.out.println("Connection sucessfull");

			DatabaseMetaData meta = con.getMetaData();
			System.out.println(meta.getDatabaseProductName());
			System.out.println(meta.getDatabaseProductVersion());
			System.out.println(meta.getDriverName());
			System.out.println(meta.getDriverVersion());
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
