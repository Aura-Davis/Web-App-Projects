<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entries</title>

<script>

var xmlHttpRequest = new XMLHttpRequest();
	

function processEntries()
{
	
var jsonEntryObject = eval('(' + xmlHttpRequest.responseText + ')');
var table = document.getElementById("entryTable");
table.innerHTML = "";
var headrow = table.insertRow(0);
var headcell = headrow.insertCell(0);
headcell.innerHTML = jsonEntryObject.title.name;
var entries = jsonEntryObject.title.entries;

var i = 0;
while (i < entries.length)
{
row = table.insertRow(i+1);
cell = row.insertCell(0);
cell.innerHTML = entries[i++].name;
}
}

</script>

<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src="js/Jquery.jsp"></script>
<script type="text/javascript" src="js/EntryJS.jsp"></script>
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


<form action="SubmitEntry" method="post">
		<table>
			<tr>
				<td>Enter Title: </td>
				<td><input type="text" name="title" /></td>
			</tr>
			
			<tr>
				<td>Enter Entry: </td>
				<td><textarea rows="10" cols="30" name="content"></textarea></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="submit" name="submit"/></td>
				<td></td>
			</tr>
		</table>
	</form>



<br><table id="entryTable" style="border:1px solid black"></table>

<script type="text/javascript" src="js/Jquery.jsp"></script>
<script type="text/javascript" src="js/EntryJS.jsp"></script>

</body>
</html>