<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="banner">
				<div class="inner">
					<header>
						<h1>Görevler</h1>
					</header>

					<div class="flex ">

						Görev Ekle :
<form action="gorev" method="post">
<input type="text" name="baslik"></br>
<textarea name="gorev" id="gorev" rows="4" cols="50">

</textarea>
<input type="submit" value="ekle">
</form>
					</div>

					<footer>
						<h2 style="color:white;">Aktif Görevler</h2>

<c:forEach items="${list}" var="gorevler">
			
				<tr>
					<td>${gorevler.id}</td>
					<td>${gorevler.baslik}</td>
					<td>${gorevler.gorevtext}</td>
					
				</tr>
				</br>
			</c:forEach>
					</footer>
				</div>
			</section>
<body>
<jsp:include page="menu.jsp"></jsp:include>  
<%


if(session.getAttribute("user")==null){
	response.sendRedirect("login.jsp");
}
%>



			${asd}
			${asd2}
</body>
</html>