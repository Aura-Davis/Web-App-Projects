<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sales Representative</title>
<link rel="stylesheet" type="text/css" href="style.css">

<script type="text/javascript" src="js/Jquery.jsp"></script>

<script>

var xmlHttpRequest = new XMLHttpRequest();
	

function processCities()
{

var jsonCityObject = eval('(' + xmlHttpRequest.responseText + ')');
var table = document.getElementById("cityTable");
table.innerHTML = "";
var headrow = table.insertRow(0);
var headcell = headrow.insertCell(0);
headcell.innerHTML = jsonCityObject.title.name;
var cities = jsonCityObject.title.cities;

var i = 0;
while (i < cities.length)
{
row = table.insertRow(i+1);
cell = row.insertCell(0);
cell.innerHTML = cities[i++].name;
}
}

</script>

</head>
<header>
	<h1>Aura Sample Database Website</h1>
	</header>
<body>

<form action="LogoutUserController" method="post">
		<table>
			<tr>
				<td><input type="submit" value="Logout" name="logout"/></td>
				<td></td>
			</tr>
		</table>
	</form>
				
<h2>Welcome User <%=request.getParameter("username") %></h2>

<script type="text/javascript">
</script>

<form action="GoToEntriesPageController" method="post">
		<table>
			<tr>
				<td>Enter City: </td>
				<td><input type="text" name="city" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="select" name="select"/></td>
				<td></td>
			</tr>
		</table>
	</form>


<br><table id="cityTable" style="border:1px solid black"></table>

<script type="text/javascript" src="js/Jquery.jsp"></script>
<script type="text/javascript" src="js/SalesRepDashboard.jsp"></script>

</body>
</html>