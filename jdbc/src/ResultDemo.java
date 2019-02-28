import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultDemo {
	public static void main(String[] args) {
		String sql="select * from person";
		Connection con=null;
		
		
		try {
			con=JdbcFactory.getConnection();
			ResultSet rs=con.createStatement().executeQuery(sql);
			
			
			ResultSetMetaData meta=rs.getMetaData();
			for(int i=1;i<=meta.getColumnCount();i++)
				System.out.print(meta.getColumnLabel(i)+"\t");   //Display column name
			
			System.out.println();
			while(rs.next())
			//	System.out.printf("%-20s%3d\t%-20s\n",rs.getString(1),rs.getInt("age"),rs.getString("city"));
			System.out.println(rs.getString(1)+"\t" +rs.getString("age")+"\t"+rs.getString("city"));

		} catch (SQLException e) {
			
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
