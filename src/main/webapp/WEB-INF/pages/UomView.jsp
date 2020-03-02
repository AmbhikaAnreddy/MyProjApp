<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<body>
<a href="excel?id=${ob.uomId}">Excel Export</a>
<a href="pdf?id=${ob.uomId}">Pdf Export</a>
<h3>WELCOME TO UOM VIEW PAGE</h3>
<table border="1">
<tr>
 <th>ID</th> <td>${ob.uomId}</td>
</tr>
 <tr>
 <th>TYPE</th> <td>${ob.uomType}</td>
</tr>
 <tr>
 <th>MODEL</th> <td>${ob.uomModel}</td>
</tr>
 <tr>
 <th>DESCRIPTION</th> <td>${ob.uomDesc}</td>
</tr>
 </table>
</body>
</html>