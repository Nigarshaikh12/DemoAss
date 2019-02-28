import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class JdbcFactory {
	public JdbcFactory() {}

	public static Connection getConnection() throws SQLException {
		Connection con = null;
		Properties p = new Properties();
		try {
			p.load(new FileReader("src/oracle.info"));
			Class.forName(p.getProperty("driver"));
			con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pass"));
		} catch (ClassNotFoundException | IOException e) {
			throw new SQLException(e.getMessage());
		}

		return con;
	}

}
