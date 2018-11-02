<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Check ID</h1>
	<div>
		<c:if test="${result eq '1'}">
		<h3>${param.id} 사용 가능한 ID 입니다.</h3>
		<button>사용하기</button>
		</c:if>
		<c:if test="${result eq '2'}">
		<h3>${param.id} 사용 불가능한 ID 입니다.</h3>
		</c:if>
	</div>
	
	<div>
		<form action="./memberCheckId.do">
			<input type="text" name="id">
			<button>중복확인</button>	
		</form>
	</div>
	
	
	
</body>
</html>