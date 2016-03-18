<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <h1>This is from mvc</h1>

        <table class="table tab-content table-striped table-bordered ">
            <tr>
                <th>Customer Id</th>
                <th>first name</th>

                <th>Last name</th>
                <th>address</th>
                <th>email</th>
                <th>contact</th>
                <th>Status</th>
                <th>Action</th>
            </tr>


            <c:forEach var="dept" items="${requestScope.customer}">
                <tr>
                    <td>${dept.customerId}</td>
                    <td>${dept.firstName}</td>
                    <td>${dept.lastName}</td>
                    <td>${dept.address}</td>
                    <td>${dept.email}</td>
                    <td>${dept.contact}</td>
                    <td>${dept.status}</td>
                    <td>
                        <a href="${SITE_URL}/assignment-management/assignments/edit.jsp?id=${dept.id}" class="btn btn-success"><span class="glyphicon glyphicon-pencil"></span></a>
                        <a href="${SITE_URL}/assignment-management/assignments/delete?id= ${dept.id}" class="btn btn-danger" onclick="return confirm('are you suer')"><span class="glyphicon glyphicon-trash"></span></a>
                    </td>
                </tr>

            </c:forEach>
        </table>



    </body>
</html>
