import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class aSS {

	public static void main(String[] args) {
		String sql = "select * from person";
		Connection con = null;
		try {
			con = JdbcFactory.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// ResultSet rs=stmt.executeQuery("delete from person where name= 'polo'
			// ");.args

			ResultSet rs = stmt.executeQuery("select name,age,city from person");
			ResultSetMetaData meta = rs.getMetaData();
			for (int i = 1; i < meta.getColumnCount(); i++) {
				System.out.print(meta.getColumnLabel(i) + "\t");
				System.out.println();

				while (rs.next()) {
					System.out.println(rs.getString(1) + "\t" + rs.getInt("age") + "\t" + rs.getString("city"));

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
