<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<style type="text/css">
	
.imgBtn{
	width: 100px;
	height: 75px;
}
body{
	background: url("images/loginBack.jpg");
	background-size: cover;
}
.container{
background: white;
padding: 10px 10px;
transform:translate(0%,50%);
max-width: 70%;
border-radius: 15px;
}

.container button a :hover{
	color: white;
}
</style>
</head>
<body>

	<div class="container">
	<button type="button" class="btn btn-outline-primary"><img alt="add_icon" src="images/addIcon.svg" class="imgBtn" onclick="location.href='View/addBus.jsp';"> Add New bus</button>
		<table id="table_id" class="table">
    <thead class="table-primary">
        <tr>
            <th>Ticket Price</th>
            <th>Available Seat</th>
            <th>Rout</th>
            <th>Available Time</th>
            <th>Type</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach items="${buses}" var="bus">
        <tr>
            <td>${bus.getTickPrice()}</td>
            <td>${bus.getSeatAval()}</td>
            <td>${bus.getRoute()}</td>
            <td>${bus.getTimeAval()}</td>
            <td>${bus.getType()}</td>
            <td><button type="button" class="btn btn-primary" style="margin: 0 4px;"  onclick="location.href='BusController?action=EDIT&id=${bus.getId()}';">Edit</button><button type="button" class="btn btn-danger" onclick="location.href='BusController?action=DELETE&id=${bus.getId()}';">Delete</button> </td>
        </tr>
       </c:forEach>
    </tbody>
</table>
	</div>
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
<script >

$(document).ready( function () {
    $('#table_id').DataTable();
} );

</script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>