<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<a href="excel">Excel Export</a>
<a href="pdf">PDF Export</a>
<h3>welcome to WhUserTypeDataPage</h3>
<c:choose>
<c:when test="${!empty list}">
<table border="1">
 <tr>
  <th>ID</th>
  <th>TYPE</th>
  <th>CODE</th>
  <th>USER FOR</th>
  <th>EMAIL</th>
  <th>CONTACT</th>
  <th>USER ID TYPE</th>
  <th>OTHER</th>
  <th>ID NUMBER</th>
  <th colspan="3">OPERATIONS</th>
 </tr>
  <c:forEach items="${list}" var="ob">
  <tr>
      <td>${ob.userId}</td>
      <td>${ob.userType}</td>
      <td>${ob.userCode}</td>
      <td>${ob.userFor}</td>
      <td>${ob.userEmail}</td>
      <td>${ob.userContact}</td>
      <td>${ob.userIdType }</td>
      <td>${ob.other}</td>
      <td>${ob.idNumber}</td>
      <td>
     <a href="delete?uid=${ob.userId}">DELETE</a>
      </td>
      <td>
      <a href="view?uid=${ob.userId}">VIEW</a>
      </td>
      <td>
      <a href="edit?uid=${ob.userId}">UPDATE</a>
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
