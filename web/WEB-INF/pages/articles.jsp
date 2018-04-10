<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 08.04.2018
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Articles</title>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Articles list</h1>

<c:if test="${!empty listArticles}">
    <table class="tg">
    <tr>
    <th width="80">id</th>
    <th width="120">name</th>
    <th width="120">text</th>
    <th width="60">Edit</th>
    <th width="60">Delete</th>
    </tr>

    <c:forEach items="${listArticles}" var="article">
        <tr>
            <td>${article.id}</td>
            <td><a href="/articledata/${article.id}" target="_blank">${article.articleName}</a></td>
            <td>${article.articleText}</td>
            <td><a href="<c:url value='/edit/${article.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/remove/${article.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>

<h1>Add your article</h1>

<c:url var="addAction" value="/articles/add"/>

<form:form action="${addAction}" commandName="article">
    <table>
        <c:if test="${!empty article.articleName}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="articleName">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="articleName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="articleText">
                    <spring:message text="Text"/>
                </form:label>
            </td>
            <td>
                <form:input path="articleText"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty article.articleName}">
                    <input type="submit"
                           value="<spring:message text="Edit article"/>"/>
                </c:if>
                <c:if test="${empty article.articleName}">
                    <input type="submit"
                           value="<spring:message text="Add article"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
