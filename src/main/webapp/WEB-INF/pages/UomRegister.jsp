<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h3>welcome to uom register page</h3>
<form:form action="save" method="post" modelAttribute="Uom">
<pre>
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
  <input type="submit" value="Create"/>
</pre>
</form:form>
${message}
</body>
</html>