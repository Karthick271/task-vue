package notes.app.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
import notes.app.db_connector.UsersEntity;
import notes.app.model.NoteModel;
 

/**
 * Servlet implementation class AddNotes
 */
@WebServlet("/AddNotes")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 1000, // 1 GB
		maxRequestSize = 1024 * 1024 * 1000)
public class AddNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNotes() {
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

		NoteModel notemodel = new NoteModel();
		
		Part part = request.getPart("image");
		InputStream in = part.getInputStream();
		notemodel.setEmail(request.getParameter("email"));
		notemodel.setNotes(request.getParameter("note"));
		notemodel.setImage(in);
		notemodel.setTitle(request.getParameter("title"));
		notemodel.setDate(request.getParameter("date"));

		try {

			Connection con = UsersEntity.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into notes(email,note,image,title,date) values(?,?,?,?,?)");

			ps.setString(1, notemodel.getEmail());
			ps.setString(2, notemodel.getNotes());
 			ps.setBlob(3, notemodel.getImage());
			ps.setString(4, notemodel.getTitle());
			ps.setString(5, notemodel.getDate());
			ps.execute();
			 
			response.getWriter().append(" new one is added");

			ps.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
