import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {
	
	public static void main(String[] args) {
		String sql1= "insert into person values('Mili',20,'Mumbai')";
		String sql2="update person set age=23 where name='polo'";
	     String sql3="delete from person where name='Nigar'";
	     Connection con=null;
	   
	     try {
			
			 con=JdbcFactory.getConnection();
			 Statement stmt=con.createStatement();
			 stmt.addBatch(sql1);
			 stmt.addBatch(sql2);
			 stmt.addBatch(sql3);
			 
			 
			 //setting auto commit off
			 
			 con.setAutoCommit(false);
			//performing DML operations
			 stmt.executeBatch();
			 //if everything goes fine - commit changes
			 con.commit();
			 System.out.println("Completed Sucessfully");
		} catch (SQLException e) {
			System.out.println("Trasaction failed");
			e.printStackTrace();
			try {
				con.rollback();                           //is used to execute 1st 2 queries;
				
			}catch(SQLException e1)
			{
				e1.printStackTrace();
			}
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
