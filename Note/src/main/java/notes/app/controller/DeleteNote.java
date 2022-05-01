package notes.app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notes.app.db_connector.UsersEntity;

/**
 * Servlet implementation class DeleteNote
 */
@WebServlet("/DeleteNote")
public class DeleteNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int status = 0;
		 int id = Integer.valueOf(request.getParameter("id"));
		    try {
		    	Connection con = UsersEntity.getConnection();
		        // delete query is given to delete the record for
		        // the given UserId
		        PreparedStatement ps = con.prepareStatement(
		            "delete from notes where  id=?");
		        ps.setInt(1, id);
		        status = ps.executeUpdate();
		        if(status != 1) response.getWriter().append("Id Not Found");
		        System.out.println("status :" + status);
		        response.getWriter().append("Successfully Deleted");
		        ps.close();
		        con.close();
		    }
		    catch (Exception e) {
		        e.printStackTrace();
		    }
		  
  
	}

}
