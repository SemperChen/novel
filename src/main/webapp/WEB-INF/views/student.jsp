<%--
  Created by IntelliJ IDEA.
  User: Semper
  Date: 2017/5/2
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@
        taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@
        taglib prefix="spring" uri="http://www.springframework.org/tags"
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Student Test</title>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <style>
        .errors {
            color: red;
        }
    </style>

</head>
<body>

<!-- 如果用户列表非空 -->
<c:if test="${!empty students}">
    <table class="table table-bordered table-striped">
        <tr>
            <th>ID</th>
            <th>名字</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${students}" var="stu">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.name}</td>
                <td>${stu.email}</td>

                <td>
                    <a href="/delete/${stu.id}" type="button" class="btn btn-sm btn-danger">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<div class="container">
    <h1>SpringMVC 添加Student</h1>
    <hr/>
    <form:form action="" method="post" modelAttribute="student" role="form">
        <div class="form-group">
            <label for="name">Title:</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name:"/>
            <form:errors path="name" cssClass="errors"/>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="Enter Email:"/>
            <form:errors path="email" cssClass="errors"/>

        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">添加</button>
        </div>
    </form:form>
    <h1>SpringMVC 修改Student</h1>
    <hr/>
    <c:if test="${!empty students}">
        <c:forEach items="${students}" var="stu">

            <form:form action="/student/update" method="post" modelAttribute="student" role="form">

                <div class="form-group">
                    <table class="table table-bordered table-striped">
                        <tr>
                            <th>ID</th>
                            <th>名字</th>
                            <th>邮箱</th>

                        </tr>

                        <tr>
                            <td>
                                <input type="text" class="form-control hidden" id="id" name="id" value="${stu.id}"/>
                            </td>
                            <td>
                                <input type="text" class="form-control" id="name1" name="name" value="${stu.name}"/>
                            </td>
                            <td>
                                <input type="text" class="form-control" id="email1" name="email" value="${stu.email}"/>

                            </td>

                        </tr>
                    </table>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-sm btn-success">修改</button>
                </div>
            </form:form>
        </c:forEach>
    </c:if>

</div>
</body>
</html>
