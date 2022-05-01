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
 * Servlet implementation class Editnotes
 */
@WebServlet("/EditNotes")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 1000, // 1 GB
		maxRequestSize = 1024 * 1024 * 1000)
public class Editnotes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Editnotes() {
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
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int status = 0;

		NoteModel notemodel = new NoteModel();

		Part part = request.getPart("image");
		notemodel.setId(Integer.valueOf(request.getParameter("id")));
		
		if(part!=null) {
			InputStream in = part.getInputStream();
			notemodel.setImage(in);
		}
		notemodel.setNotes(request.getParameter("note"));
		
		notemodel.setTitle(request.getParameter("title"));
		
		try {

			Connection con = UsersEntity.getConnection();

			PreparedStatement ps = con.prepareStatement("update set notes note=?, image=?, title=? where  id=?");

			ps.setString(1, notemodel.getNotes());
			ps.setBlob(2, notemodel.getImage());
			ps.setString(3, notemodel.getTitle());
			ps.setInt(4, notemodel.getId());
			status = ps.executeUpdate();
			System.out.println(" status " + status);
			con.close();

			response.getWriter().append("edited");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
