<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Meals</title>
    <style type="text/css">
        TABLE {
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
        }
        TH, TD {
            border: 1px solid black; /* Параметры рамки */
            padding: 4px; /* Поля вокруг текста */
        }
        TR {
            color: green;
        }
        TR.tittle {
            color: black;
        }
        TR.excess {
            color: red;
        }
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<section>
    <table>
        <tr class="tittle">
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
        </tr>
<c:forEach var="meal" items="${meals}">
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
    <tr<%=(meal.isExcess()) ? " class=\"excess\"" : ""%>>
        <td><%=TimeUtil.formatDate(meal.getDateTime())%></td>
        <td>${meal.description}</td>
        <td>${meal.calories}</td>
    </tr>
</c:forEach>
    </table>
</section>
</body>
</html>