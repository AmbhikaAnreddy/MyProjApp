<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<a href="excel">Excel Export</a>
<a href="pdf">PDF Export</a>
<h3>WELCOME TO ORDER METHOD DATA PAGE</h3>
<c:choose>
<c:when test="${!empty list}">
<table border="1">
<tr>
 <th>ID</th>
 <th>MODE</th>
 <th>CODE</th>
 <th>TYPE</th>
 <th>ACCEPT</th>
 <th>NOTE</th>
 <th colspan="3">OPERATIONS</th>
</tr>
<c:forEach items="${list}" var="ob">
<tr>
  <td>${ob.orderId}</td>
  <td>${ob.orderMode}</td>
  <td>${ob.orderCode}</td>
  <td>${ob.orderType}</td>
  <td>${ob.orderAcpt}</td>
  <td>${ob.description}</td>
  <td>
  <a href="delete?oid=${ob.orderId}">DELETE</a>
 </td>
 <td>
  <a href="edit?oid=${ob.orderId}">UPDATE</a>
 </td>
 <td>
  <a href="view?oid=${ob.orderId}">VIEW</a>
  </td>
 </tr>
 </c:forEach>
 </table>
 </c:when>
 <c:otherwise>
 <h4>No data found</h4>
 </c:otherwise>
</c:choose>
</body>
</html>
