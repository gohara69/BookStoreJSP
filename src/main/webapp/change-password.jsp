<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change password</title>
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
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container text-center">
	<%
		String eRetype = request.getAttribute("eRetype") + "";
		eRetype = eRetype.equals("null") ? "" : eRetype;
		
		String ePassword = request.getAttribute("ePassword") + "";
		ePassword = ePassword.equals("null") ? "" : ePassword;
		
		String eNewPassword = request.getAttribute("eNewPassword") + "";
		eNewPassword = eNewPassword.equals("null") ? "" : eNewPassword;
		
		String success = request.getAttribute("success") + "";
		success = success.equals("null") ? "" : success;
		KhachHang khachHang = (KhachHang)session.getAttribute("khachHang");
		if(khachHang != null){
	%>
		<!-- Form change password -->
		<form action="changePassword" method="post" class="form-signin" id="change-password-form">
			<h3 class="h3 mt-5 fw-normal">Change password</h3>
			
			<div class="form-floating">
				<input class="form-control" type="password" id="last-password" name="last-password" placeholder="Last password">
				<label for="password">Last Password</label>
			</div>
			<span class="red-alert" id="error-last-password"><%= ePassword%></span>
			
			<div class="form-floating mt-2">
				<input class="form-control" type="password" id="new-password" name="new-password" placeholder="New password">
				<label for="new-password">New Password</label>
			</div>
			<span class="red-alert" id="error-new-password"><%= eNewPassword%></span>
			
			<div class="form-floating mt-2">
				<input class="form-control" type="password" id="retype-new-password" name="retype-new-password" placeholder="Retype New password">
				<label for="new-password">Retype New Password</label>
			</div>
			<span class="red-alert" id="error-retpye-new-password"><%= eRetype%></span>
			<span class="red-alert"><%= success%></span>
			<% if(success.length() == 0){ %>
			<button type="button" class="btn btn-primary w-100 mt-5" onclick="validatePassword()">Change</button>
			<%} else { %>
			<div class="row">
				<div class="col">
					<button type="button" class="btn btn-primary" onclick="validatePassword()">Change</button>
				</div>
				<div class="col">
					<a class="btn btn-primary" href="index.jsp">Home</a>
				</div>
			</div>
			<%} %>
		</form>
		<%} else { %>
		
		<!-- Form to notify not signing in -->
		<form class="w-50 text-center mx-auto">
			<h1 class="h3 mt-5 fw-normal">Notification</h1>
			<p class="mt-5 fw-normal text-start">Sorry, you aren't signed in so you can't access to this function</p>
			<p class="fw-normal text-start">Press OK to get back to home page</p>
			<a class="btn btn-primary w-100 mt-5" href="index.jsp">OK</a>
		</form>
		<%}%>
	</div>
<script>
	function validatePassword(){
		lastPassword = document.getElementById("last-password").value;
		newPassword = document.getElementById("new-password").value;
		retypeNewPassword = document.getElementById("retype-new-password").value;
		changePasswordForm = document.getElementById("change-password-form");
		valid = true;
		
		if(lastPassword.trim().length == 0){
			document.getElementById("error-last-password").innerHTML = "Please enter your last password";
			valid = false;
		} else {
			document.getElementById("error-last-password").innerHTML = "";
		}
		
		if(newPassword.trim().length == 0){
			document.getElementById("error-new-password").innerHTML = "Please retype your new password";
			valid = false;
		} else {
			document.getElementById("error-new-password").innerHTML = "";
		}
		
		if(retypeNewPassword.trim().length == 0){
			document.getElementById("error-retpye-new-password").innerHTML = "Please enter your last password";
			valid = false;
		} else {
			document.getElementById("error-retpye-new-password").innerHTML = "";
		}
		
		if(valid){
			changePasswordForm.submit();
		}
	}
</script>
</body>
</html>