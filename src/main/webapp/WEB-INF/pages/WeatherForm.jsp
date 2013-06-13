<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
	<h2>Weather By ZIP</h2>
	<spring:url var="action" value='/weather/retrieve' />
	<form:form method="POST" commandName="weather" action="${action}">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>ZIP Code :</td>
				<td><form:input path="zipCode" /></td>
				<td><form:errors path="zipCode" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
	<c:if test="${not empty weather.city}">
		<table border="5" width="50%" cellpadding="4" cellspacing="3">
			<tr>
				<th colspan="4" align="center"><br>
					<h3>Weather Stats by ZIP</h3>
				</th>
			</tr>
			<tr>
				<th>ZIP</th>
				<th>City</th>
				<th>State</th>
				<th>Temperature(f)</th>
			</tr>
			<tr align="center">
				<td>${weather.zipCode}</td>
				<td>${weather.city}</td>
				<td>${weather.state}</td>
				<td>${weather.currentTemp}</td>
			</tr>
		</table>
	</c:if>
</body>
</html>