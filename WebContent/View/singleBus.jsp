<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
	
<style type="text/css">
body {
	background: url("images/loginBack.jpg");
	background-size: cover;
}
.container {
	background: white;
	padding: 10px 10px;
	transform: translate(0%, 20%);
	max-width: 70%;
	border-radius: 15px;
}
</style>
</head>
<body>
	<div class="container">

		<form action="${pageContext.request.contextPath}/BusController?action=UPDATE" method="post">
	
  <div class="form-group">
    <label for="exampleInputEmail1">Ticket Price</label>
    <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${bus.getTickPrice()}" name="ticketPrice">
  </div>
 <div class="form-group">
    <label for="exampleInputEmail1">Available Seat</label>
    <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${bus.getSeatAval()}" name="avalSeat">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Route</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${bus.getRoute()}" name="route">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Available Times</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${bus.getTimeAval()}" name="avalTime">
  </div>
 <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Select Type</label>
  <select class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref"  name="type">
    <option selected value="${bus.getType()}">${bus.getType()}</option>
    <option value="A/C">A/C</option>
    <option value="Non-A/C">Non-A/C</option>
  </select>
  <input type="text" value="${bus.getId()}" name="id" hidden>
  <center><button type="submit" class="btn btn-primary">Update</button></center>
	
	
	</form>
	
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>