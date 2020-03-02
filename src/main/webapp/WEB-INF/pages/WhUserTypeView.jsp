<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <html>
 <body>
 <h3>WELCOME TO WHUSER TYPE VIEW PAGE</h3>
 <table border="1">
 <tr>
  <th>ID</th> <td>${ob.userId}</td>
 </tr>
 
  <tr>
  <th>TYPE</th> <td>${ob.userType}</td>
 </tr>
 
  <tr>
  <th>CODE</th> <td>${ob.userCode}</td>
 </tr>
 
  <tr>
  <th>USER FOR</th> <td>${ob.userFor}</td>
 </tr>
 
  <tr>
  <th>EMAIL</th> <td>${ob.userEmail}</td>
 </tr>
 
  <tr>
  <th>CONTACT</th> <td>${ob.userContact}</td>
 </tr>
 
  <tr>
  <th>ID TYPE</th> <td>${ob.userIdType}</td>
 </tr>
 
  <tr>
  <th>OTHER</th> <td>${ob.other}</td>
 </tr>
 
  <tr>
  <th>ID NUMBER</th> <td>${ob.idNumber}</td>
 </tr>
 </table>
 </body>
 </html>
