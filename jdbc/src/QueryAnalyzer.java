import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class QueryAnalyzer {
	public static void main(String[] args) {
		String sql = "select name from person";
		Connection con = null;
		try {
			con = JdbcFactory.getConnection();

			ResultSet ts = con.createStatement().executeQuery(sql);
			ResultSetMetaData meta = ts.getMetaData();
			for (int i = 1; i <= meta.getColumnCount(); i++)

			{
				System.out.print(meta.getColumnLabel(i) + "\t");
				System.out.println();

				while (ts.next()) {
					System.out.println(ts.getString(i) + "\t");

				}

			}

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
