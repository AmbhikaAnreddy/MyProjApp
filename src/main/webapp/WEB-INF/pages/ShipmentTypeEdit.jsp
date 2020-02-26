<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h3>welcome to shipment type edit page</h3>
<form:form action="update" method="post" modelAttribute="ShipmentType">
<pre>
Shipment Id:
<form:input path="shipId" readOnly="true"/>
 Shipment Mode:
  <form:select path="shipMode">
  <form:option value="">-select-</form:option>
  <form:option value="Air">Air</form:option>
  <form:option value="Train">Train</form:option>
  <form:option value="Truck">Truck</form:option>
  <form:option value="Ship">Ship</form:option>
  </form:select>
 Shipment Code:
  <form:input path="shipCode"/>
 Enable Shipment:
  <form:select path="enbShip">
  <form:option value="">-select-</form:option>
  <form:option value="Yes">Yes</form:option>
  <form:option value="No">No</form:option>
  </form:select>
 Shipment Grade:
  <form:radiobutton path="shipGrad" value="A"/>A
  <form:radiobutton path="shipGrad" value="B"/>B
  <form:radiobutton path="shipGrad" value="C"/>C
 Description:
  <form:textarea path="shipDesc"/>
  <input type="submit" value="update"/>
  </pre>
  </form:form>
  </body>
  </html>


