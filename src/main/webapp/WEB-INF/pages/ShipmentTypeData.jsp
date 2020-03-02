<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<a href="excel">Excel Export</a>
<a href="pdf">Pdf Export</a>
<h3>welcome to ShipmentTypeDataPage</h3>
<c:choose>
<c:when test="${!empty list}">
<table border="1">
 <tr>
  <th>ID</th>
  <th>CODE</th>
  <th>GRADE</th>
  <th>MODE</th>
  <th>ENABLE</th>
  <th>NOTE</th>
  <th colspan="3">OPERATIONS</th>
 </tr>
  <c:forEach items="${list}" var="ob">
  <tr>
      <td>${ob.shipId}</td>
      <td>${ob.shipMode}</td>
      <td>${ob.shipCode}</td>
      <td>${ob.enbShip}</td>
      <td>${ob.shipGrad}</td>
      <td>${ob.shipDesc}</td>
      <td>
     <a href="delete?sid=${ob.shipId}">DELETE</a>
      </td>
      <td>
      <a href="view?sid=${ob.shipId}">VIEW</a>
      </td>
      <td>
      <a href="edit?sid=${ob.shipId}">UPDATE</a>
      </td>
      </tr>
  </c:forEach>
</table>
</c:when>
<c:otherwise>
<h4>No Data Found!!!!</h4>
</c:otherwise>
</c:choose>
</body>
</html>
