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
<form action="gorevver" method="post">
Kullanıcı Adı<input type="text" name="user" placeholder="Kullanıcı Adını Girin" >
<input type="text" name="baslik" placeholder="Görev Başlığı Girin"></br>
<textarea name="gorev" id="gorev" rows="4" cols="50" placeholder="Görev Metni Girin">

</textarea>
<input type="submit" value="ekle">
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


<h2>Aktif Görevler</h2>


		
</body>
</html>