    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="urlpaket.Urloku" %>
    <%@ page import="bean.UserAccount" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="java.util.List" %>
	<section id="banner">
				<div class="inner">
					<header>
						<h1>Welcome Page</h1>
					</header>

					<div class="flex ">

	WELCOME ${user}
					</div>

					<footer>
						${rol }
	<form action="UrlServlet" method="post">
	Google Sonuçlarını Getir : <input type="text" name="kelime">
	<input type="submit">
	</form>

    <c:forEach items="${list}" var="item">
			<tr>
      <td><c:out value="${item}" /></td>
    </tr>
				</br>
 	</c:forEach>
					</footer>
				</div>
			</section>
	<meta charset="UTF-8">
	<title>Welcome Page</title>
	</head>
	<body>
	<jsp:include page="menu.jsp"></jsp:include>  
	<%
	if(session.getAttribute("user")==null){
		response.sendRedirect("login.jsp");
	}
	UserAccount user = new UserAccount();
	String rol = user.getRole();
	pageContext.setAttribute("rol", rol);
	%>

	
	
 	
 	
<form action="logout">
<input type="submit" value="logout">
</form>
</body>
</html>