<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="banner">
				<div class="inner">
					<header>
						<h1>Ayarlar</h1>
					</header>

					<div class="flex ">
Site Başlıgı =
<form action="ayarServlet" method="post">
Site Basligi = <input type="text" name="baslik">
<input type="submit">

</form>
					</div>

					<footer>
						
					</footer>
				</div>
			</section>
<jsp:include page="menu.jsp"></jsp:include>  
<%


if(session.getAttribute("user")==null){
	response.sendRedirect("login.jsp");
}
%>

</body>
</html>