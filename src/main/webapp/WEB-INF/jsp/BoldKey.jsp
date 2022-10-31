<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CognitiveServiceを使うサイト(KeyPhrases太字)</title>
</head>
<body>
<a href="./hello">hello</a>
<a href="./result">Result</a>
<a href="./languageRequest">LanguageRequest</a>
<a href="./Key">KeyResult</a>
<a href="./Key2">KeyResult2</a>
<a href="./Bold">KeyBold</a>
<a href="./Sen1">Sentiments</a>

<h1>CognitiveServiceを使うサイト(KeyPhrases)</h1>

<h3>キーワードを抽出したい文字列を入力してください。</h3>

<form method="POST" action="./Bold">
<input type="TEXT" name="aa" >
<input type="submit" />
</form>

</body>
</html>