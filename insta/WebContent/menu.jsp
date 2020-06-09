
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page import="Filter.Filter2" %>

<!DOCTYPE HTML>
<!--
	Projection by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Yonetim Sistemi</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<div class="inner">
					<a href="index.html" class="logo"><strong>Projection</strong> by TEMPLATED</a>
					<nav id="nav">
						
						<% if (session.getAttribute("user")== null) { %>

<a href="${pageContext.request.contextPath}/login">
 Login
</a>
<a href="${pageContext.request.contextPath}/register">
  Register
</a>    

<% } %>
<a href="${pageContext.request.contextPath}/welcome.jsp">
  Welcome
</a>

   <% if (session.getAttribute("editor")!= null) { %>
<a href="Yazilar">Yazilar</a>
<% } %>

<% if (session.getAttribute("admin")!= null) { %>

 <a href="Yonetim">Yönetim</a>
 
 <a href="gorevver">Görev Ver</a>
  <a href="ayarlar.jsp">Ayarlar</a>
</a>

<% } %>

<% if (session.getAttribute("user")!= null) { %>

    <a href="gorev">Görevler</a>||
    <a href="${pageContext.request.contextPath}/logout">
  Logout
</a>

<% } %>
					</nav>
					<a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>
				</div>
			</header>
			

		







 
&nbsp;
<span style="color:red">[ ${userName} ]</span>