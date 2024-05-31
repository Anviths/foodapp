<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food product</title>
<style type="text/css">
/* Form container */
form {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    font-family: Arial, sans-serif;
}

/* Form header */
h1 {
    text-align: center;
    font-size: 24px;
}

/* Form input fields */
form input[type="text"],
form input[type="number"],
form textarea,
form select {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
}

/* Radio buttons container */
.radio-buttons {
    margin-top: 10px;
}

/* Radio buttons */
form input[type="radio"] {
    margin-right: 10px;
}

/* Submit button */
form button {
    background-color: #e50914;
    color: #fff;
    border: none;
    border-radius: 4px;
    font-size: 16px;
    padding: 12px 20px;
    cursor: pointer;
}

form button:hover {
    background-color: #d10812;
}
</style>
</head>
<body>
    	 <c:set var="userlogin" value="${userlogin}" scope="session" />
    <div class="navbar">
        <a class="navbar-button home-button"
            href="branchmanager.jsp?sessionId=${sessionScope.userlogin.getId()}">Home</a>
        <div class="user-info">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMM9iuYpLlg4Z4qGzMITpHX9PmdEERT-GHtv7RXnVa7SXaJ6-pdi48oj792H-zPNBpiG0&usqp=CAU" alt="User Icon">
            <span>Welcome, ${sessionScope.userlogin.getName()}</span>
        </div>
        <a class="navbar-button" href="login">Logout</a>
    </div>  
 <h1>food product</h1>
  <form:form action="saveproduct" modelAttribute="foodProduct">
  
   Product name<form:input path="name"/><br><br>
   Product price<form:input path="price"/><br><br>
    Product Availabilty 
  <form:radiobutton path="availabilty" value="AVAILABILE" label="AVAILABILE"/>
  <form:radiobutton path="availabilty" value="NOTAVAILABLE" label="NOTAVAILABLE"/><br><br>
    Product Type
  <form:radiobutton path="type" value="VEG" label="VEG"/>
  <form:radiobutton path="type" value="NONVEG" label="NONVEG"/><br><br>
   Product about :<form:textarea path="about"/><br><br>
   Menu: <form:select path="menu.id">
        <form:options items="${menu}" itemValue="id" itemLabel="id" />
    </form:select><br><br>
  <form:button>Create</form:button> <br><br>
  </form:form>

</body>
</html>