package gki2;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Database {
      public static void main(String[] args) {
		java.sql.Connection conn;
		     try {
		    	 
		    	 String dbURL = "jdbc:sqlserver://localhost;databaseName=users;user=sa;password=123456789";
		    	 conn = DriverManager.getConnection(dbURL);
		    	 if (conn != null ) {
		    		 JOptionPane.showMessageDialog(null, "Ket noi thanh cong");
		    	 }
		     } catch (SQLException ex) {
		    	 JOptionPane.showMessageDialog(null, ""+ex);
		     }
	}
}