package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Any;

import unit.DBTool;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();

         
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		
		
        
        DBTool dbTool = new DBTool();
         
        
        try {
      
			ResultSet result = dbTool.query("select * from person;");
			while (result.next()) {
			   String name = result.getString("name");
			   int    age  = result.getInt("age");
			   int    sex  = result.getInt("sex");
			   response.getWriter().println(name + "今年" + age + "岁" + "性别" + sex + "<br/>");
			   
				
		     
				
			}
			
		  	response.getWriter().println("success");		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.getWriter().println("yichang");
			
			e.printStackTrace();
		}
        
        
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
