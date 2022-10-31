<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テキストの感情を分析するサイト</title>
</head>
<%  Object o = request.getAttribute("aa"); 
    String message = (String)o;
    Object p = request.getAttribute("e"); 
    String message0 = (String)p; 
    Object q = request.getAttribute("bb"); 
    double message1 = (double)q; 
    Object r = request.getAttribute("cc"); 
    double message2 = (double)r;    
    Object s = request.getAttribute("dd"); 
    double message3 = (double)s; 
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

<H3>文字列：</H3><p><%=request.getAttribute("aa") %></p>
<H3>結果：</H3><p><%=request.getAttribute("e") %></p>
<H3>それぞれの数値</H3>
<p>negative： <%= request.getAttribute("bb") %>％</p>
<p>neutral： <%= request.getAttribute("cc") %>％</p>
<p>positive：<%= request.getAttribute("dd") %>％</p>

</body>
</html>