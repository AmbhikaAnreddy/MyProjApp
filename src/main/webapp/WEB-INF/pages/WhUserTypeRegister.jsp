<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h3>WHUSER TYPE REGISTER PAGE</h3>
<form:form action="save" method="post" modelAttribute="WhUserType">
<pre>
User Type:
 <form:radiobutton path="userType" value="vendor"/>VENDOR
 <form:radiobutton path="userType" value="customer"/>CUSTOMER
User Code:
 <form:input path="userCode"/>
User For:
 <form:input path="userFor"/>
User Email:
 <form:input path="userEmail"/>
User Contact:
 <form:input path="userContact"/>
User Id Type:
 <form:select path="userIdType">
  <form:option value=" ">--SELECT--</form:option>
  <form:option value="PanCard">PanCard</form:option>
  <form:option value="AadharCard">AadharCard</form:option>
  <form:option value="VoterId">VoterId</form:option>
  <form:option value="Other">Other</form:option>
</form:select>
If Other:
 <form:input path="other"/>
ID Number:
 <form:input path="idNumber"/>
<input type="submit" value="create user"/>
</pre>
</form:form>
${message}
</body>
</html>