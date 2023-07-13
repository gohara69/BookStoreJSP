<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trang đăng ký</title>
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
</head>
<body>
	<%
		String usernameString = request.getAttribute("username") + "";
		String username = usernameString.equals("null") ? "" : usernameString;
		
		String eUsernameString = request.getAttribute("e_username") + "";
		String eUsername = eUsernameString.equals("null") ? "" : eUsernameString;
		
		String passwordString = request.getAttribute("password") + "";
		String password = passwordString.equals("null") ? "" : passwordString;
		
		String retypeString = request.getAttribute("retype") + "";
		String retype = retypeString.equals("null") ? "" : retypeString;
		
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
	%>
	<div class="container">
		<h1 class="d-flex justify-content-center">SIGNUP ACCOUNT</h1>
		<form action="../khach-hang" method="post" id="form">
			<input type="hidden" name="hanhDong" value="dang-ky"/>
			<div class="row">
				<div class="col-md-6">
					<h3>Account</h3>
					<label for="username" class="form-label">
						User name
						<span class="red-alert">(*)</span>
						<span class="red-alert" id="error-username"><%= eUsername %></span>
					</label> 
					<input type="text" class="form-control" id="username" name="username" value="<%= username%>" required="required"> 
					
					<label for="password" class="form-label">
						Password
						<span class="red-alert">(*)</span>
						<span class="red-alert" id="error-password"></span>
					</label> 
					<input type="password" class="form-control" id="password" name="password" value="<%= password%>" required="required"> 
					
					<label for="retype-password" class="form-label">
						Retype Password
						<span class="red-alert">(*)</span>
						<span class="red-alert" id="error-retype"></span>
					</label> 
					<input type="password" class="form-control" id="retype-password" name="retype-password" value="<%= retype%>" required="required">
					<hr>

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
</body>
<script>
	function checkValid(){
		form = document.getElementById("form");
		validateUsername();
		validatePassword();
		validateRetypePassword();
		validatePhoneNumber();
		
		if(validateUsername() && validatePassword() && validateRetypePassword() && validatePhoneNumber()){
			form.submit();
		}
	}
	
	function validateUsername(){
		username = document.getElementById("username").value;
		if(username.trim().length == 0){
			document.getElementById("error-username").innerHTML = "Please enter username";
			return false;
		} else if(username.trim().length < 3){
			document.getElementById("error-username").innerHTML = "Username must have at least 10 characters";
			return false;
		} else {
			document.getElementById("error-username").innerHTML = "";
			return true;
		}
	}
	
	function validatePassword(){
		password = document.getElementById("password").value;
		if(password.trim().length == 0){
			document.getElementById("error-password").innerHTML = "Please enter your password";
			return false;
		} else {
			document.getElementById("error-password").innerHTML = "";
			return true;
		}
	}
	
	function validateRetypePassword(){
		retype = document.getElementById("retype-password").value;
		password = document.getElementById("password").value;
		if(retype.trim().length == 0){
			document.getElementById("error-retype").innerHTML = "Please enter your password";
			return false;
		}
		
		if(retype == password){
			document.getElementById("error-retype").innerHTML = "";
			return true;
		} else {
			document.getElementById("error-retype").innerHTML = "Password doesn't match";
			return false;
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