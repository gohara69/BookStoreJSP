<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signin</title>
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
<link href="../css/style.css" rel="stylesheet">
</head>
<body class="text-center">
	<%
		String error = request.getAttribute("error") + "";
		error = error.equals("null") ? "" : error;
		
		String username = request.getAttribute("username") + "";
		username = username.equals("null") ? "" : username;
	%>
	<div class="form-signin">
		<form action="../khach-hang" method="post">
			<input type="hidden" name="hanhDong" value="dang-nhap"/>
			<img class="mb-4" src="https://img.freepik.com/free-vector/hand-drawn-flat-design-bookstore-logo-template_23-2149337115.jpg?w=740&t=st=1688047314~exp=1688047914~hmac=f8277ea4406b01b9dbe031329999af5479c16fbe548ba8e4b0d9015de10401f6" alt="logo" width="100">
			<h1 class="h3 mb-3 fw-normal">Sign in</h1>

			<div class="form-floating">
				<input type="text" class="form-control" id="username" name="username" value="<%= username%>" placeholder="Username"> 
				<label for="floatingInput">Username</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="password" name="password" placeholder="Password"> 
				<label for="floatingPassword">Password</label>
			</div>

			<div class="text-start mb-3">
				<label> 
					<input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<span id="error" class="red-alert"><%= error%></span>
			<button class="w-100 btn btn-primary btn-lg" type="submit">Signin</button>
			<a href="sign-up.jsp" class="text-start text-decoration-none">Sign up if you don't have an account</a>
			<p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
		</form>
	</div>
</body>
</html>