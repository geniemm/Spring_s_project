<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="hd">
	<h1> CARE LAB </h1>
</div>
<hr>

<nav class="menu">
	<a href="index">HOME</a>
	<a href="memberInfo">회원정보</a>
	<c:choose>
		<c:when test="${id==null }">
		<a href="login">로그인</a>
		</c:when>
		<c:otherwise>
		<a href="logout">로그아웃</a>
		</c:otherwise>	
	</c:choose>
</nav>
<hr>
</body>
</html>