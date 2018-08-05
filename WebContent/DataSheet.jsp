<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page  import="java.util.*" %>
<%@ page  import="com.xrq.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品信息</title>
<%
	String name = (String)request.getSession().getAttribute("name");
	if(name==null)  response.sendRedirect("ErrorPage.jsp");
	int PageCount = (int)request.getAttribute("PageCount");
	int PageNow = (int)request.getAttribute("PageNow");
    int PageRow = (int)request.getAttribute("PageRow");
    ArrayList<DataBean> al = (ArrayList<DataBean>)request.getAttribute("result");
    System.out.println("ArrayListSize: "+al.size());
    
%>
</head>
<h1>商品信息</h1>
<body>
<p>你好： <%=name %></p>
<table border ="1"  style="width: 60%">
<tr>
<td>商品ID</td><td>商品名称</td><td>商品价格</td><td>商品数量</td>
</tr>

<%
	System.out.print("pagerow:"+PageRow);
	for(int i=0;i<PageRow;i++)
	{%>
		<tr>
		<td><%= al.get(i).getID() %></td><td><%= al.get(i).getName() %></td>
		<td><%= al.get(i).getPrice() %></td><td><%= al.get(i).getNumber() %></td>
		</tr>
	<%}%>
</table>
<p>
	<% if (PageNow>1){ %>
	<a href = "ProductData?PageNow=<%=PageNow-1%>">上一页</a>
	<%}
	for(int j=PageNow;j<PageNow+5;j++)
	{%>
	<a href="ProductData?PageNow=<%=j%>"><%=j%></a>
	<%}
	 if (PageNow<PageCount){ %>
	<a href = "ProductData?PageNow=<%=PageNow+1%>">下一页</a>
	<%}%>
</p>
</body>
</html>