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
<c:import url="../default/header.jsp" />
	<div>
		<h3>회원가입 페이지 입니다</h3>
		<form action="register" method="post">
			<input type="text" name="id" placeholder="아이디"><br>
			<input type="text" name="pw" placeholder="비밀번호"><br>
			<input type="text" name="addr" placeholder="주소"><br>			
			<input type="submit" value="회원가입">
		</form>
	</div>
<c:import url="../default/footer.jsp" />
</body>
</html>