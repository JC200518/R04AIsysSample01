<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CognitiveServiceを使うサイト</title>
</head>

<body>
<a href="./hello">hello</a>
<a href="./result">Result</a>
<a href="./languageRequest">LanguageRequest</a>
<a href="./Key">KeyResult</a>
<a href="./Key2">KeyResult2</a>
<a href="./Bold">KeyBold</a>
<a href="./Sen1">Sentiments</a>

<h1>CognitiveServiceを使うサイト</h1>

<h3>調べたい文字列を教えてください</h3>
<form method="POST" action="./result">
<input type="TEXT" name="string" />
<input type="submit" />
</form>
</body>
</html>