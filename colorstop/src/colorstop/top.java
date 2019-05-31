package colorstop;
import java.sql.*;
import java.util.*;
public class top {
	
	static String loc1 ="com.mysql.jdbc.Driver";
	static String loc2 = "jdbc:mysql://localhost:3306/colorstop";

	public Connection connect(String user,String password) throws Exception {
		Class.forName(loc1);
		Connection can = DriverManager.getConnection(loc2,user,password);
	return can;	
	}
	
	public static void main(String args[]) {
new authentication();	
//new b2("root","root");
//new newstock("root","root");
	}
}

