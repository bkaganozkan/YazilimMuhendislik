<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <section id="banner">
				<div class="inner">
					<header>
						<h1>Giriş Yap</h1>
					</header>

					<div class="flex ">
	<form action="login" method="post">
	Kullanıcı adı = <input type="text" name="uname"><br>
	Şifre = <input type="password" name="pass">
	<input type="submit" value="login">
	</form>
	<p style="color: red;">${errorMessage}</p>
	<a href="${pageContext.request.contextPath}/register">
  Kayıt Ol
</a>   
					</div>

					<footer>
				
					</footer>
				</div>
			</section>
<jsp:include page="menu.jsp"></jsp:include>  



</body>
</html>