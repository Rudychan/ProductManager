<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆成功</title>
</head>
<% 
	String name = (String)request.getSession().getAttribute("name");
	if(name ==null)
		request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
%>
<h1 style = “text-align:center” >数据管理系统</h1>
<body>
<br>
	<p>欢迎： <%= name %></p>
<hr>
<br>
<a href ="ProductData">查看商品数据</a>
<br>
<hr>
</body>
</html>