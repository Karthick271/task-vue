package notes.app.db_connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class UsersEntity {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/note_pad", "root", "");
			if (con != null)
				System.out.println("Connected");
			else
				System.out.println("Not Connected");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
