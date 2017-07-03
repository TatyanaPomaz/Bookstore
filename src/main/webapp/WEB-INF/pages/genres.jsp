<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="script" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>

<html>
<head>
    <title>Genre page</title>

    <script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
    <%--<script type="text/javascript" src="<c:url value="js/javascript.js"/>"></script>--%>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css"/>

</head>
<body>


<h1>Genre List</h1>
<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listGenres}" var="genre">
        <tr>
            <td>${genre.id}</td>
            <td>${genre.name}</td>
            <td><a href="<c:url value='/editgenre/${genre.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/removegenre/${genre.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<c:if test="${!empty genre.name}">
    <h1>Edit the Genre</h1>
</c:if>
<c:if test="${empty genre.name}">
    <h1>Add a Genre</h1>
</c:if>

<%--<a class="popup-link-1" href="">Add a Genre</a>--%>

<c:url var="addAction" value="/genres/add"/>

<form:form action="${addAction}" commandName="genre">
    <%--<div class="popup-box" id="popup-box-1">--%>
    <%--<div class="close">X</div>--%>
    <%--<div class="top">--%>
    <%--<h2>Add a Genre</h2>--%>
    <%--</div>--%>
    <%--<div class="bottom">--%>
    <table>
        <tr>
            <td>
                <form:label path="id"><spring:message text="ID"/></form:label>
            </td>
            <td>
                <form:input path="id" readonly="true" size="8" disabled="true"/>
                <form:hidden path="id"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="name"><spring:message text="Name"/></form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
    </table>

    <br/>
    <input type="submit" value="<spring:message text= "Submit"/>"/>
    <input type="reset" value="<spring:message text= "Cancel"/>"/>
    <%--</div>--%>
    <%--</div>--%>
</form:form>

</body>
</html>
