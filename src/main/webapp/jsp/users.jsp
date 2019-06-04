<%--
  Created by IntelliJ IDEA.
  User: Z30
  Date: 24.04.2019
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Users</title>
        <style type="text/css">

            .form-style-6{
                font: 95% Arial, Helvetica, sans-serif;
                max-width: 400px;
                margin: 10px auto;
                padding: 16px;
                background: #F7F7F7;
            }
            .form-style-6 h1{
                background: #43D1AF;
                padding: 20px 0;
                font-size: 140%;
                font-weight: 300;
                text-align: center;
                color: #fff;
                margin: -16px -16px 16px -16px;
            }
            .form-style-6 input[type="text"],
            .form-style-6 input[type="date"],
            .form-style-6 input[type="datetime"],
            .form-style-6 input[type="email"],
            .form-style-6 input[type="number"],
            .form-style-6 input[type="search"],
            .form-style-6 input[type="time"],
            .form-style-6 input[type="url"],
            .form-style-6 input[type="password"],
            .form-style-6 textarea,
            .form-style-6 select
            {
                -webkit-transition: all 0.30s ease-in-out;
                -moz-transition: all 0.30s ease-in-out;
                -ms-transition: all 0.30s ease-in-out;
                -o-transition: all 0.30s ease-in-out;
                outline: none;
                box-sizing: border-box;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                width: 100%;
                background: #fff;
                margin-bottom: 4%;
                border: 1px solid #ccc;
                padding: 3%;
                color: #555;
                font: 95% Arial, Helvetica, sans-serif;
            }
            .form-style-6 input[type="text"]:focus,
            .form-style-6 input[type="date"]:focus,
            .form-style-6 input[type="datetime"]:focus,
            .form-style-6 input[type="email"]:focus,
            .form-style-6 input[type="number"]:focus,
            .form-style-6 input[type="search"]:focus,
            .form-style-6 input[type="time"]:focus,
            .form-style-6 input[type="url"]:focus,
            .form-style-6 input[type="password"]:focus,
            .form-style-6 textarea:focus,
            .form-style-6 select:focus
            {
                box-shadow: 0 0 5px #43D1AF;
                padding: 3%;
                border: 1px solid #43D1AF;
            }

            .form-style-6 input[type="submit"],
            .form-style-6 input[type="button"]{
                box-sizing: border-box;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                width: 100%;
                padding: 3%;
                background: #43D1AF;
                border-bottom: 2px solid #30C29E;
                border-top-style: none;
                border-right-style: none;
                border-left-style: none;
                color: #fff;
            }
            .form-style-6 input[type="submit"]:hover,
            .form-style-6 input[type="button"]:hover{
                background: #2EBC99;
            }


            table {
                border-collapse: collapse;
                text-align:center;
                margin-left:auto;
                margin-right:auto;
                align-items: center;
            }

            table, th, td {
                border: 1px solid black;
            }

            td, th {
                width: 300px;
                height: 35px;
            }

        </style>
    </head>
    <body>
        <div class="form-style-6">
            <h1>Add User!</h1>
            <form method="post" action="users">
                <input type="text" name="name" placeholder="Add Name" />
                <input type="text" name="email" placeholder="Add Email" />
                <input type="text" name="age" placeholder="Add Age" />
                <input type="submit" value="Add user" />
            </form>
        </div>

        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Age</th>
            </tr>
            <c:forEach items="${usersFromServer}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.age}</td>
                    <td><a href="/cr_2_war/delete/${user.id}">Delete</a></td>
                    <td><a href="/cr_2_war/update/${user.id}">Update</a></td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
