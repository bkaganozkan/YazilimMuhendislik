<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>  
<%


if(session.getAttribute("user")==null){
	response.sendRedirect("login.jsp");
}
%>


<form action="Yazilar" method="post">
<input type="text" name="baslik"></br>
<textarea name="baslik" id="baslik" rows="4" cols="50">

</textarea>
<input type="submit" value="ekle">
</form>
</body>
</html>