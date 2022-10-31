<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String message = 
		(String) request.getAttribute("message");

%>

<body>
<a href="./hello">hello</a>
<a href="./result">Result</a>
<a href="./languageRequest">LanguageRequest</a>
<a href="./Key">KeyResult</a>
<a href="./Key2">KeyResult2</a>
<a href="./Bold">KeyBold</a>
<a href="./Sen1">Sentiments</a>

<H1><%= message %></H1>
</body>
</html>