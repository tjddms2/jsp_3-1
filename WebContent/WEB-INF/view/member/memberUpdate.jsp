<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../../../temp/header.jsp" />
	<div class="container-fluid">
		<div class="row">
			<form action="./memberUpdate.do" method="post" enctype="multipart/form-data">
		    <div class="form-group">
		      <label for="title">ID:</label>
		      <input type="text" value="${member.id}" readonly="readonly" class="form-control" id="title" placeholder="Enter Title" name="id">
		    </div>
		    <div class="form-group">
		      <label for="writer">PW:</label>
		      <input type="password" value="${member.pw}" class="form-control" id="writer" placeholder="Enter Writer" name="pw">
		    </div>
		    <div class="form-group">
		      <label for="title">NAME:</label>
		      <input type="text" value="${member.name}" class="form-control" id="title" placeholder="Enter Title" name="name">
		    </div>
		    <div class="form-group">
		      <label for="title">Email:</label>
		      <input type="email" value="${member.email}" class="form-control" id="title" placeholder="Enter Title" name="email">
		    </div>

		    
		    <div class="form-group">
		      <label for="file">File:</label>
		      <input type="file" class="form-control" id="file" name="f1">
		    </div>
		    
		    
		    
		    <button type="submit" class="btn btn-default">Write</button>
		  </form>
	
		
		
		
		</div>
	</div>


<c:import url="../../../temp/footer.jsp" />
</body>
</html>