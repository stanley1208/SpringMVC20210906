<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Auth error page</title>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
</head>
<body style="padding: 10px">
	<form class="pure-form">
		<fieldset>
			<legend>Auth error page</legend>
			<h2>exception:${exception}</h2>
			<h3>
			exception.date:
			<fmt:formatDate value="${exception.date}"
							pattern="yyyy-MM-dd"/>
			</h3>
			<h3>exception.message:${exception.message}</h3>
		</fieldset>	
	</form>
</body>
</html>