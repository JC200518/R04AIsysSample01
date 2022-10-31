<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テキストの感情を分析するサイト</title>
</head>
<body>
<a href="./hello">hello</a>
<a href="./result">Result</a>
<a href="./languageRequest">LanguageRequest</a>
<a href="./Key">KeyResult</a>
<a href="./Key2">KeyResult2</a>
<a href="./Bold">KeyBold</a>
<a href="./Sen1">Sentiments</a>

<h1>テキストの感情を分析するサイト</h1>

<h3>分析したい文字列を入力してください</h3>
<form method="POST" action="./Sen1">
<input type="TEXT" name="string" />
<input type="submit" />
</form>
</body>
</html>