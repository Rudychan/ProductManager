package com.xrq;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataSolve
 */
@WebServlet("/DataSolve")
public class DataSolve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataSolve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int PageCount=0;
		int PageRow=5;
		int PageNow=1;
		int TotalItem=0;
		String getPage = (String)request.getParameter("PageNow");
		if(getPage!=null) PageNow = Integer.parseInt(getPage);
		System.out.println("PageNow: "+getPage);
		ArrayList<DataBean> al = new ArrayList<>();
		TotalItem = new DBSolve().TotalItem();
		if(TotalItem%PageRow ==0 )
		{
			PageCount = TotalItem/PageRow;
		}else 
		{
			PageCount = TotalItem/PageRow+1;
		}
		al = new DBSolve().DataResulta(PageNow, PageRow);
		request.setAttribute("PageCount", PageCount);
		request.setAttribute("PageRow", PageRow);
		request.setAttribute("PageNow", PageNow);
		request.setAttribute("result", al);
		request.getRequestDispatcher("DataSheet.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
