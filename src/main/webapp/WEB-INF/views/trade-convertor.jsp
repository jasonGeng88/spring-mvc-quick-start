<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: gengjie
  Date: 2018/2/22
  Time: 下午4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<body>
<h3> Message : ${msg}</h3>
<spring:eval expression="msg" />
<p>BuySell: ${trade.buySell}</p>
<p>Buy Currency: ${trade.buyCurrency}</p>
<p>Sell Currency: ${trade.sellCurrency}</p>
<p>Price: <spring:eval expression="trade.price" /></p>
</body>
</html>