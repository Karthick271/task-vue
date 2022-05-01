package notes.app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Blob;

import notes.app.db_connector.UsersEntity;
import notes.app.model.NoteModel;
import notes.app.model.UserModel;

/**
 * Servlet implementation class ViewAllNotes
 */
@WebServlet("/ViewAllNotes")

public class ViewAllNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAllNotes() {
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
		response.setContentType("text/plain;charset=UTF-8");

		UserModel userdata = new UserModel();
		userdata.setEmail(request.getParameter("email"));
		// Timestamp added_date = new Timestamp(System.currentTimeMillis());
		List<NoteModel> getNotes = new ArrayList<NoteModel>();
		NoteModel noteModel = new NoteModel();

		try {

			Connection con = UsersEntity.getConnection();

			PreparedStatement ps;
			ps = con.prepareStatement("select * from notes where email=?");
			ps.setString(1, request.getParameter("email"));

			ResultSet rs = ps.executeQuery();

			Blob blob;
			String base = null;
			while (rs.next()) {
				noteModel.setId(rs.getInt(1));
				noteModel.setNotes(rs.getString(3));
				blob = (Blob) rs.getBlob(4);
				int len = (int) blob.length();
				base = Base64.getEncoder().encodeToString(blob.getBytes(1L, len));
				noteModel.setBase64(base);
				noteModel.setTitle(rs.getString(5));
				noteModel.setDate(rs.getString(6));
				getNotes.add(noteModel);
			}
			response.getWriter().append(base);
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
