<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CognitiveServiceを使うサイト(KeyPhrases)</title>
</head>
<%
	Object o  = request.getAttribute("aa");
	String[] message1 = (String[])o;
%>
<body>
<a href="./hello">hello</a>
<a href="./result">Result</a>
<a href="./languageRequest">LanguageRequest</a>
<a href="./Key">KeyResult</a>
<a href="./Key2">KeyResult2</a>
<a href="./Bold">KeyBold</a>
<a href="./Sen1">Sentiments</a>

<h1>CognitiveServiceを使うサイト(KeyPhrases)</h1>
<h1>元の文章</h1>
<p><%=request.getAttribute("String") %></p>

<h1>Key Phrases一覧</h1>
<p><% String[] ss = message1;
		for(String s: ss){
	%>
	<%= s %>
	<% } %>
</p>

</body>
</html>