<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="urlpaket.Urloku" %>
    <%@ page import="bean.UserAccount" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="java.util.List" %>
<section id="banner">
				<div class="inner">
					<header>
						<h1>Görevler</h1>
					</header>

					<div class="flex ">

					<h1>Ayarlar</h1>
<p> Kullanıcı Ekle </p>
p>${NOTIFICATION}</p>
<form action="Yonetim" method="post">
<input type="text" name="baslik"></br>
<textarea name="gorev" id="gorev" rows="4" cols="50">

</textarea>
<input type="submit" value="ekle">
</form>
<
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Id</th>
				<th>Name</th>
				<th>Rol</th>
				<th>Actions</th>
			</tr>
<c:forEach items="${list}" var="employee">
			
				<tr>
					<td>${employee.id}</td>
					<td>${employee.username}</td>
					<td>${employee.role}</td>
					<td> 
						<a href = "${pageContext.request.contextPath}/Yonetim?action=EDIT&id=${employee.id}">Edit</a> 
						| 
						<a href = "${pageContext.request.contextPath}/Yonetim?action=DELETE&id=${employee.id}">Delete</a> 
					</td>
				</tr>
				</br>
			</c:forEach>
			
			</table>
					</div>

					<footer>
						
			
					</footer>
				</div>
			</section>
<jsp:include page="menu.jsp"></jsp:include> 
	<%
	if(session.getAttribute("admin")==null){
		response.sendRedirect("login.jsp");
	}
	UserAccount user = new UserAccount();
	String rol = user.getRole();
	pageContext.setAttribute("rol", rol);
	%>
<meta charset="UTF-8">


			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>