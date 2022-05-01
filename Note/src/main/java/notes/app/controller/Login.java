package notes.app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import notes.app.db_connector.UsersEntity;
import notes.app.model.UserModel;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel userdata = new UserModel();

		HttpSession session = request.getSession();
		
		String dbEmail = null;
		String dbPassword = "";
		String res="";
		
		userdata.setEmail(request.getParameter("email"));
		userdata.setPassword(request.getParameter("password"));

		try {

			Connection con = UsersEntity.getConnection();
 
			PreparedStatement ps = con.prepareStatement("select * from users where email=?");
			ps.setString(1, request.getParameter("email"));
 
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				dbEmail = rs.getString(2);
				dbPassword = rs.getString(3);
//				System.out.println("res" + rs.next());
			}

			if (dbEmail == null) {
				res =" Email Id  Not Found.";
				System.out.println(" use id is : " + dbEmail);
				
			} else if (dbPassword.equals(userdata.getPassword())) {
			   session.setAttribute("email", dbEmail);
				res = "Login sucessfull";
			} else {
				res = "Invalid Password";
				 
			}
			response.getWriter().append(res);
			// System.out.println(rs.next() );
			ps.close();
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
