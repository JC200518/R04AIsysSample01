<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テキストの感情を分析するサイト</title>
</head>
<%  Object o = request.getAttribute("aa"); 
    String message1 = (String)o;
 %>

<body>
<a href="./hello">hello</a>
<a href="./result">Result</a>
<a href="./languageRequest">LanguageRequest</a>
<a href="./Key">KeyResult</a>
<a href="./Key2">KeyResult2</a>
<a href="./Bold">KeyBold</a>
<a href="./Sen1">Sentiments</a>

<h1>分析結果</h1>

<H3>文字列：<%=request.getAttribute("aa") %></H3>
<H3>結果：<%= request.getAttribute("bb") %></H3>

</body>
</html>