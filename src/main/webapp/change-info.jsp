<%@page import="java.sql.Date"%>
<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Change information</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
	integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
	crossorigin="anonymous"></script>
<style>
.red-alert {
	color: red;
}
</style>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<%
		String fullnameString = request.getAttribute("fullname") + "";
		String fullname = fullnameString.equals("null") ? "" : fullnameString;
		
		String sexString = request.getAttribute("sex") + "";
		String sex = sexString.equals("null") ? "" : sexString;
		
		String dateOfBirthString = request.getAttribute("dateOfBirth") + "";
		String dateOfBirth = dateOfBirthString.equals("null") ? "" : dateOfBirthString;
		
		String customerAddressString = request.getAttribute("customerAddress") + "";
		String customerAddress = customerAddressString.equals("null") ? "" : customerAddressString;
		
		String diliveryAddressString = request.getAttribute("diliveryAddress") + "";
		String diliveryAddress = diliveryAddressString.equals("null") ? "" : diliveryAddressString;
		
		String phoneString = request.getAttribute("phone") + "";
		String phone = phoneString.equals("null") ? "" : phoneString;
		
		String ePhoneString = request.getAttribute("e_phone") + "";
		String ePhone = ePhoneString.equals("null") ? "" : ePhoneString;
		
		String emailString = request.getAttribute("email") + "";
		String email = emailString.equals("null") ? "" : emailString;
		
		String eEmailString = request.getAttribute("e_email") + "";
		String eEmail = eEmailString.equals("null") ? "" : eEmailString;
		
		String agreePolicyString = request.getAttribute("agreePolicy") + "";
		String agreePolicy = agreePolicyString.equals("null") ? "" : agreePolicyString;
		
		String agreeTakeEmailString = request.getAttribute("agreeTakeEmail") + "";
		String agreeTakeEmail = agreeTakeEmailString.equals("null") ? "" : agreeTakeEmailString;
		
		KhachHang khachHang = (KhachHang)session.getAttribute("khachHang");
		if(khachHang != null){
	%>
	<div class="container">
		<h1 class="d-flex justify-content-center">CHANGE INFORMATION</h1>
		<form action="register" method="post" id="form">
			<div class="row">
				<div class="col-md-6">
					<h3>Customer Information</h3>
					<label for="fullname" class="form-label">Full name</label> 
					<input type="text" class="form-control" id="fullname" value="<%= fullname%>" name="fullname">

					<label for="sex" class="form-label">Sex</label> 
					<select name="sex" id="sex" class="form-control">
						<option value="Male"   <%= sex.equals("Male") ? "selected" : "" %>>Male</option>
						<option value="Female" <%= sex.equals("Female") ? "selected" : "" %>>Female</option>
						<option value="Other"  <%= sex.equals("Other") ? "selected" : "" %>>Other</option>
					</select> 
					
					<label for="date-of-birth" class="form-label">Date of birth</label> 
					<input type="date" class="form-control" id="date-of-birth" value="<%= dateOfBirth.equals("") ? "" : Date.valueOf(dateOfBirth) %>" name="date-of-birth">
				</div>
				
				<div class="col-md-6">
					<h3>Address</h3>
					<label for="customer-address" class="form-label">Customer Address</label> 
					<input type="text" class="form-control" id="customer-address" value="<%= customerAddress%>" name="customer-address">
					
					<label for="dilivery-address" class="form-label">Dilivery Address</label> 
					<input type="text" class="form-control" id="dilivery-address" value="<%= diliveryAddress%>" name="dilivery-address">
					
					<label for="phone" class="form-label">
						Phone Number
						<span class="red-alert">(*)</span>
						<span class="red-alert" id="error-phone"><%= ePhone%></span>
					</label> 
					<input type="text" class="form-control" id="phone" value="<%= phone%>" name="phone" required="required">
					
					<label for="email" class="form-label">
						Email
						<span class="red-alert">(*)</span>
						<span class="red-alert" id="error-email"><%= eEmail%></span>
					</label> 
					<input type="email" class="form-control" id="email" name="email" value="<%= email%>" required="required">
					
					<label for="agree-policy" class="form-label">
						Agree with
						<a style="color: blue; cursor: pointer;">company policy</a>
						<span class="red-alert">(*)</span>
					</label> 
					<input type="checkbox" id="agree-policy" name="agree-policy" <%= agreePolicy.equals("on") ? "checked" : ""%> required="required">
					<br>
					<label for="agree-take-email" class="form-label">
						Agree to take notification through email
					</label> 
					<input type="checkbox" id="agree-take-email" <%= agreeTakeEmail.equals("on") ? "checked" : ""%> name="agree-take-email">
					<hr>
					<button class="form-control btn btn-primary" type="button" onclick="checkValid()">Sign up</button>
				</div>
			</div>
		</form>
	</div>
	<%} else { %>
		<!-- Form to notify not signing in -->
		<form class="w-50 text-center mx-auto">
			<h1 class="h3 mt-5 fw-normal">Notification</h1>
			<p class="mt-5 fw-normal text-start">Sorry, you aren't signed in so you can't access to this function</p>
			<p class="fw-normal text-start">Press OK to get back to home page</p>
			<a class="btn btn-primary w-100 mt-5" href="index.jsp">OK</a>
		</form>
	<%} %>
</body>
<script>
	function checkValid(){
		form = document.getElementById("form");
		validatePhoneNumber();
		
		if(validatePhoneNumber()){
			form.submit();
		}
	}
	
	function validatePhoneNumber(){
		phone = document.getElementById("phone").value;
		if(phone.trim().length == 0){
			document.getElementById("error-phone").innerHTML = "Please enter your phone number";
			return false;
		} else {
			document.getElementById("error-phone").innerHTML = "";
			return true;
		}
	}
</script>
</html>