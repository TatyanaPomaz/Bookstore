<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
>%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Books page</title>

    <script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="javascript.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/style.css"/>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg .tg-4epx {
            background-color: #f9f9f9;
        }

    </style>
</head>
<body>
<%--<a href="../../index.jsp">Back to main menu</a>--%>

<br/>
<br/>

<h1>Book List</h1>
<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Title</th>
        <th width="120">Description</th>
        <th width="80">Price</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listBooks}" var="book">
        <tr>
            <td>${book.id}</td>
            <td><a href="/bookdata/${book.id}" target="_blank">${book.title}</a></td>
            <td>${book.description}</td>
            <td>${book.price}</td>
            <td><a href="<c:url value='/edit/${book.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/remove/${book.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<h1>Add a Book</h1>

<a class="popup-link-1" href="">Add a Book</a>

<div class="popup-box" id="popup-box-1">
    <div class="close">X</div>
    <div class="top">
        <h2>Add a Book</h2>
    </div>
    <div class="bottom">
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

            <button type="submit" h>OK</button>
            <button type="reset">Cancel</button>
        </form:form>
    </div>
</div>

<br/>
<a href="<c:url value="/genres"/>" target="_blank">Genres list</a>
<br/>

</body>
</html>