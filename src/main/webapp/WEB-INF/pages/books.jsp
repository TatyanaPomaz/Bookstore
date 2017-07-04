<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Books page</title>

    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css"/>

</head>
<body>

<h1>Book List</h1>
<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Title</th>
        <th width="120">Description</th>
        <th width="120">Genre</th>
        <th width="80">Price</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listBooks}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.description}</td>
            <td>${book.genres}</td>
            <td>${book.price}</td>
            <td><a href="<c:url value='/edit/${book.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/remove/${book.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<c:if test="${!empty book.title}">
    <h1>Edit the Book</h1>
</c:if>
<c:if test="${empty book.title}">
    <h1>Add a Book</h1>
</c:if>

<c:url var="addAction" value="/books/add"/>

<form:form action="books/add" commandName="book">
    <table>
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
        <tr>
            <td>
                <form:label path="title">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="title"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>
        </tr>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<form:label path="genres">--%>
                    <%--<spring:message text="Genre"/>--%>
                <%--</form:label>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<table>--%>
                    <%--<c:if test="${empty book.title}">--%>
                        <%--<form:checkboxes path="genres" items="${listGenres}"/>--%>
                        <%--<br/>--%>
                    <%--</c:if>--%>
                <%--</table>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <tr>
            <td>
                <form:label path="price">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price"/>
            </td>
        </tr>
    </table>

    <br/>
    <br/>
    <input type="submit" value="<spring:message text= "Submit"/>"/>
    <button type="reset">Cancel</button>
</form:form>


<br/>
<a href="<c:url value="/genres"/>" target="_blank">Genres list</a>
<br/>

</body>
</html>