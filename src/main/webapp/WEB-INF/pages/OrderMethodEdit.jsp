<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h3>WELCOME TO ORDER METHOD EDIT PAGE</h3>
<form:form action="update" method="post" modelAttribute="OrderMethod">
<pre>
ORDER ID:
 <form:input path="orderId" readOnly="true"/>
ORDER MODE:
 <form:radiobutton path="orderMode" value="Sale"/>Sale
 <form:radiobutton path="orderMode" value="Purchase"/>Purchase
ORDER CODE:
 <form:input path="orderCode"/>
ORDER TYPE:
 <form:select path="orderType">
 <form:option value=" ">--select</form:option>
 <form:option value="FIFO">FIFO</form:option>
 <form:option value="LIFO">LIFO</form:option>
 <form:option value="FCFO">FCFO</form:option>
 <form:option value="FEFO">FEFO</form:option>
 </form:select>
ORDER ACCEPT:
 <form:checkbox path="orderAcpt" value="Multi-Model"/>Multi-Model
 <form:checkbox path="orderAcpt" value="Accept-Return"/>Accept-Return
DESCRIPTION:
 <form:textarea path="description"/>
<input type="submit" value="update"/>
 </pre>
</form:form>
</body>
</html>