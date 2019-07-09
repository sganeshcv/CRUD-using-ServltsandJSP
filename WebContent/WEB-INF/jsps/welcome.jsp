<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="result1" scope="request" class="com.student.Student" />

<!DOCTYPE html>
<html style="padding-right: 330px;padding-left: 200px;">
<head>

<link rel="stylesheet" href="css/normalize.css">

<link rel="stylesheet" href="css/style.css">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profile</title>
<link rel="stylesheet" href="css/normalize.css">
<link href='http://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/main.css">

<style>

table.comicGreen {
  font-family: "Comic Sans MS", cursive, sans-serif;
  border: 2px solid #4F7849;
  background-color: #EEEEEE;
  width: 100%;
  text-align: left;
  border-collapse: collapse;
}
table.comicGreen td, table.comicGreen th {
  border: 1px solid #4F7849;
  padding: 3px 2px;
}
table.comicGreen tbody td {
  font-size: 19px;
  color: #4F7849;
}
table.comicGreen tr:nth-child(even) {
  background: #CEE0CC;
}
table.comicGreen tfoot td {
  font-size: 21px;
}
</style>
</head>
<body>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>

<fieldset>
	<legend><h1><span class="number"></span> Welcome <%=result1.getName()%>:</h1> </legend>
	<table class="comicGreen" style="height: 200px;width: 850px;"">
		<tbody>
			<tr style="height: 47px;">
			<td style="width: 29.2091%; height: 47px;">Name</td><td style="width: 56.791%; height: 47px;"><%=result1.getName()%></td></tr>
			<tr>
		<td style="width: 29.2091%; height: 47px;">Email</td><td style="width: 56.791%; height: 47px;"><%=result1.getEmail()%></td></tr>
			<tr>
			<td style="width: 29.2091%; height: 47px;">DOB</td><td style="width: 56.791%; height: 47px;"><%=result1.getDob()%></td></tr>
			<tr>
		<td style="width: 29.2091%; height: 47px;">ID</td><td style="width: 56.791%; height: 47px;"><%=result1.getID()%></td></tr>
		</tbody>
		</tr>
	</table>
	<br>
	<form action="Logout" method="post">	
	    <button type="submit"> Logout </button>
	</form>
</fieldset>
</body>
</html>
