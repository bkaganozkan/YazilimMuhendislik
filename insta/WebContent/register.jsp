<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="banner">
				<div class="inner">
					<header>
						<h1>Kayıt Ol</h1>
					</header>

					<div class="flex ">

					<form action="register" method="post">
Kullanıcı adı: <input type="text" name="uname">
Şifre : <input type="password" name="pass">
<input type="submit" value="register">
</form>
<p style="color: red;">${errorMessage}</p>
					</div>

					<footer>
						
					</footer>
				</div>
			</section>
<body>
<jsp:include page="menu.jsp"></jsp:include>  


</body>
</html>