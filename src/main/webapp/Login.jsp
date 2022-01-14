<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String s=(String)session.getAttribute("user");
	if(s=="admin")
	{
		out.println("Admin was registered already");
	}
	else if (s=="mentor")
	{
		out.println("Mentor was registered already");
	}
	else if(s=="student")
	{
		out.println("student was registered already");
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Login</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>
    <div class="login">
        <form action="./login" method="post">
            <h1>Login</h1>
            <i class="fa fa-user-circle icon" aria-hidden="true"></i><br>
            <div style="margin-left: 30px;">
                <label> Username : </label><br>
                <input type="text" name="username" placeholder="Id number" required>
                <br>
                <label>Password : </label><br>
                <input type="password" name="password" placeholder="password" required>
                <div class="but">
                    <button><a class="anchor" >Submit</a></button>
                </div>
            </div>
            <p style="margin-left: 15px;">Create a new Account <a href="">Signin</a></p>
        </form>
    </div>
</body>
</html>