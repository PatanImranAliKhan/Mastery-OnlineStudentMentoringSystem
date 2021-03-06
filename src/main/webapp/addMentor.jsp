<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<%@ page import="Database.DBConnection" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Mentor</title>
    <link rel="stylesheet" href="Admin_Add_men.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <!-- <iframe src="admin_header.html" name="targetframe" allowTransparency="true" scrolling="no" frameborder="0" style="width: 100%;">
    </iframe> -->
    <% 
    	Connection con=Database.DBConnection.getconnection();
    %>
    <div class="total">
        <span style="height: 10px;">&nbsp;</span>
        <h1 style="text-align: center;margin-bottom: 40px;">Add Mentor</h1>
        <div style="width: 90%; margin: 30px;">
            <form class="mentor_form" action="./addMentor" method="post">
                <label>Mentor Name</label>
                <div>
                    <input type="text" id="mname" minlength="3" name="mentorname" placeholder="Mentor Name" value="" oninput="CheckName()" required>
                    <i class="fa fa-check-circle icon1" id="suc_1_m"></i>
                    <i class="fa fa-exclamation-circle icon2" id="fail_1_m"></i>
                    <small id="err1_m" class="error"></small>
                </div>
                <label>Email</label>
                <div>
                    <input type="email" id="email" minlength="12" name="email" placeholder="example@gmail.com" value="" oninput="CheckEmail()" required>
                    <i class="fa fa-check-circle icon1" id="suc_3"></i>
                    <i class="fa fa-exclamation-circle icon2" id="fail_3"></i>
                    <small id="err3" class="error"></small>
                </div>
                <label>Mobile Number</label>
                <div>
                    <input type="number" id="mobile" name="mobile" placeholder="Mobile number" value="" oninput="CheckMobile()" required>
                    <i class="fa fa-check-circle icon1" id="suc_4"></i>
                    <i class="fa fa-exclamation-circle icon2" id="fail_4"></i>
                    <small id="err4" class="error"></small>
                </div>
                <label>Mentor Id</label>
                <div>
                    <input type="number" id="mid" name="mid" placeholder="Mentor Id" value="" oninput="CheckIdMentor()" required>
                    <i class="fa fa-check-circle icon1" id="suc_2"></i>
                    <i class="fa fa-exclamation-circle icon2" id="fail_2"></i>
                    <small id="err2" class="error"></small>
                </div>
                <label>Department</label>
                <select name="dept" id="dept" required>
                    <option value="" disabled selected hidden>Select</option>
                    <option value="CSE">CSE</option>
                    <option value="ECE">ECE</option>
                    <option value="EEE">EEE</option>
                    <option value="ME">ME</option>
                    <option value="BT">BT</option>
                    <option value="PE">PE</option>
                </select>
                <label>Year</label>
                <select name="year" id="year" required>
                    <option value="" disabled selected hidden>Select</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
                <label>Semester</label>
                <select name="sem" id="sem" required>
                    <option value="" disabled selected hidden>Select</option>
                    <option value="1">Odd</option>
                    <option value="2">Even</option>
                </select>
                <label>password</label>
                <div>
                    <input type="password" minlength="8" maxlength="30" id="mpassword" name="password" placeholder="Password" value="" oninput="CheckpasswordMen()" required>
                    <i class="fa fa-check-circle icon1" id="suc_5"></i>
                    <i class="fa fa-exclamation-circle icon2" id="fail_5"></i>
                    <small id="err5" class="error"></small>
                </div>
                <button onclick="Submit()">Add</button>
            </form>
        </div>
    </div>
    <script src="Admin_Add.js"></script>
</body>
</html>