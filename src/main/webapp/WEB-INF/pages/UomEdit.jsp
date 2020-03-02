<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h2>welcome to uom edit page</h2>
<form:form action="update" method="post" modelAttribute="Uom">
<pre>
Uom Id:
 <form:input path="uomId" readOnly="true"/>
Uom Type:
 <form:select path="uomType">
 <form:option value="">--select--</form:option>
 <form:option value="Packing"></form:option>
 <form:option value="NoPacking"></form:option>
 </form:select>
 Uom Model:
  <form:input path="uomModel"/>
 Description:
  <form:textarea path="uomDesc"/>
  <input type="submit" value="update"/>
</pre>
</form:form>
</body>
</html>
