<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<a href="excel">Excel Export</a>
<a href="pdf">Pdf Export</a>
 <h1>welcome to Uom Data</h1>
 <c:choose>
 <c:when test="${!empty list}">
 <table border="1">
 <tr>
    <th>ID</th>
    <th>TYPE</th>
    <th>MODEL</th>
    <th>NOTE</th>
    <th colspan="3">OPERATIONS</th>
 </tr>
  <c:forEach items="${list}" var="ob">
  <tr>
    <td>${ob.uomId}</td>
    <td>${ob.uomType}</td>
    <td>${ob.uomModel}</td>
    <td>${ob.uomDesc}</td>
    <td>
    <a href="delete?uid=${ob.uomId}">DELETE</a>
    </td>
    <td>
    <a href="edit?uid=${ob.uomId}">UPDATE</a>
    </td>
   <td>
    <a href="view?uid=${ob.uomId}">VIEW</a>    
   </td>
  </tr>
  </c:forEach>
 </table>
 </c:when>
 <c:otherwise>
 <h3>No data Found!!!</h3>
 </c:otherwise>
 </c:choose>
</body>
</html>
