package com.xrq;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class LoginSolve
 */
@WebServlet("/LoginSolve")
public class LoginSolve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSolve() {
        super(); 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String InputName ="";
		String InputPassword="";
		InputName = request.getParameter("user");
		InputPassword = request.getParameter("password");
		HttpSession hs = request.getSession();
		hs.setAttribute("name", InputName);
		hs.setMaxInactiveInterval(30);
		if(new DBSolve().verify(InputName, InputPassword)) 
		{
			System.out.println("登陆验证通过");
			response.sendRedirect("Result.jsp");
		}else
		{
			System.out.println("登陆失败");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
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
