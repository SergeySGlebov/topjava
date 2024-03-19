<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo" scope="request"/>
    <title><%=meal.getId()==null ? "Add new meal" : "Edit meal"%></title>
</head>
<body>
<form method="POST" action="meals" enctype="application/x-www-form-urlencoded">
    <input type="hidden" name="id" value="${meal.id}">
    <dl>
        <dt>Дата:</dt>
        <dd><input type="datetime-local" name="date" size=50 value="${meal.dateTime}"></dd>
    </dl>
    <dl>
        <dt>Описание:</dt>
        <dd><input type="text" name="description" size=50 value="${meal.description}"></dd>
    </dl>
    <dl>
        <dt>Калории:</dt>
        <dd><input type="text" name="calories" size=50 value="${meal.calories}"></dd>
    </dl>
    <hr>
    <button type="submit">Сохранить</button>
    <button onclick="window.history.back()">Отменить</button>
</form>
</body>
</html>
