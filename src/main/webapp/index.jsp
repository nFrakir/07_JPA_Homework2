<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.gmail.silverleaf.annn.dbobjects.Dish"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Menu</title>
    <meta charset="utf-8">
    <link rel='stylesheet' href='style.css' type='text/css' media='all' />
</head>
<body>
    <h2>Actions:</h2>
    <fieldset>
        <legend>Filters</legend>
        <a href="/">All dishes</a>
        <br>
        <a href="/?discount=1">Has Discount</a>
        <br>
        <a href="/?weight=1">Generate menu with total weight < 1 kg</a>
        <fieldset>
            <legend>Price diapason</legend>
            <form class="inner" name="price_filter" action="/" method="post">
                <label class="personal" for="from">from: </label>
                <input type="text" name="from" id="from" value="100">
                <label class="personal" for="to">to: </label>
                <input type="text" name="to" id="to" value="100">
                <br>
                <input type="submit" value="Filter">
            </form>
        </fieldset>
    </fieldset>
    <fieldset>
        <legend>Add new dish</legend>
        <form name="add_new" action="/?add=1" method="post">
            <table>
                <thead>
                    <th></th>
                    <th></th>
                </thead>
                <tbody>
                    <tr>
                        <td><label class="personal" for="title">Title: </label></td>
                        <td><input type="text" name="title" id="title" value="test2"></td>
                    </tr>
                    <tr>
                        <td><label class="personal" for="price">Price: </label></td>
                        <td><input type="text" name="price" id="price" value="100"></td>
                    </tr>
                    <tr>
                        <td><label class="personal" for="weight">Weight: </label></td>
                        <td><input type="text" name="weight" id="weight" value="100"></td>
                    </tr>
                    <tr>
                        <td><label class="personal" for="discount">Discount: </label></td>
                        <td><input type="checkbox" name="discount" id="discount" value="1"></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td><input type="submit" value="Add"></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </fieldset>
    <h3>Dish list</h3>
    <table>
        <thead>
            <th class="outer">Dish title</th>
            <th class="outer">Dish price</th>
            <th class="outer">Dish weight</th>
            <th class="outer">Has discount</th>
        </thead>
        <tbody>
        <c:forEach items="${dishes}" var="dish">
            <tr>
                <td><c:out value="${dish.getTitle()}" /></td>
                <td><c:out value="${dish.getPrice()}" /></td>
                <td><c:out value="${dish.getWeigth()}" /></td>
                <td>
                    <c:if test="${dish.getIs_discount() eq true}">
                        Yes
                    </c:if>
                    <c:if test="${dish.getIs_discount() eq false}">
                        No
                    </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>