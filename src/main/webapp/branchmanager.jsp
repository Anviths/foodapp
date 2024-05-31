<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
/* Reset some default styles */
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

/* Body styles */
body {
	font-family: "Arial", sans-serif;
	background-color: #f5f5f5;
	margin: 0;
}

/* Navbar styles */
.navbar {
	background-color: #007bff;
	color: white;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 10px 20px;
	height: 60px;
}

.navbar-button {
	text-decoration: none;
	color: white;
	padding: 10px 20px;
	border-radius: 3px;
	font-size: 16px;
}

.navbar-button:hover {
	background-color: #0056b3;
}

.user-info {
	display: flex;
	align-items: center;
	color: white;
}

.user-info img {
	width: 24px;
	height: 24px;
	margin-right: 5px;
}

/* Wrapper styles */
.wrapper {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.inner {
	display: flex;
	flex-direction: column;
	align-items: center;
}

/* Button styles */
button {
	background-color: #007bff;
	color: white;
	border: none;
	padding: 10px 20px;
	font-size: 16px;
	border-radius: 3px;
	cursor: pointer;
	margin-top: 10px;
	width: 200px; /* Set a fixed width for all buttons */
	height: 40px; /* Set a fixed height for all buttons */
}

button span a {
	text-decoration: none;
	color: white;
}

button:hover {
	background-color: #0056b3;
}
</style>

</head>
<body>
	<c:set var="userlogin" value="${userlogin}" scope="session" />
	<div class="navbar">
		<a class="navbar-button home-button" href="branchmanager.jsp?sessionId=${sessionScope.userlogin.getId()}"> Home </a>
		<div class="user-info">
			<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMM9iuYpLlg4Z4qGzMITpHX9PmdEERT-GHtv7RXnVa7SXaJ6-pdi48oj792H-zPNBpiG0&usqp=CAU" alt="User Icon"> <span>Welcome,${sessionScope.userlogin.getName()}</span>
		</div>
		<a class="navbar-button" href="login"> Logout </a>
	</div>
	<div class="wrapper">
		<div class="inner">
			<button>
				<span><a href="signup">Create staff</a></span>
			</button>

			<button>
				<span><a href="createmenu">Create menu</a></span>
			</button>
			 <button>
				<span><a href="findstaff">Display staff</a></span>
			</button> 
			<button>
				<span><a href="viewmenu">View Menu</a></span>
			</button>
			
		</div>
	</div>
</body>
</html>