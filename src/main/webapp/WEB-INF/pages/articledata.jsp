<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArticleData</title>
</head>

<body>
<h1>Article Details</h1>

<table class="tg">
    <tr>
        <th width="80">id</th>
        <th width="120">name</th>
        <th width="120">text</th>
        <th width="120">userid</th>
    </tr>
    <tr>
        <td>${article.id}</td>
        <td>${article.articleName}</td>
        <td>${article.articleText}</td>
        <td>${article.userid}</td>
    </tr>
</table>
</body>
</html>
