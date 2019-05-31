package colorstop;

import java.sql.*;

public class connection extends top {

connection(String user, String pass){
	try {
		Class.forName(loc1);
		DriverManager.getConnection(loc2,user,pass);	
		new newstock(user,pass);
		
	}
	catch(Exception ae)
	{
		System.out.println(ae);
		//new authentication();
	}
}
}
