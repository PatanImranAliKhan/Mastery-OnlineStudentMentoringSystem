<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mentor Assign Subject</title>
    <link rel="stylesheet" href="men_ass_sub.css">
</head>
<body>
	<% 
	String s=(String)session.getAttribute("mentorsubjects");
	String[] arr=s.split(",");
	%>
    <div class="body">
        <div class="subject">
            <form class="subjectform" action="./mensssub" method="post">
                <span>&nbsp;</span>
                <h2>Add Subject To The Mentor</h2>
                <div class="formatting">
                    <label>Subject : </label>
                    <select name="subject" id="subject" required>
                        <option value="" disabled selected hidden>Select</option>
                        <%
                    	for(String sub:arr)
                    	{
                        %>
                        <option value="<%= sub %>"><%= sub %></option>
                        <% 
                        } 
                        %>
                    </select>
                </div>
                <button>Save</button>
            </form>
        </div>
    </div>
</body>
</html>