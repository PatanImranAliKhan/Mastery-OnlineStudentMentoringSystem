<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	String s=(String)session.getAttribute("user");

	String det=(String)session.getAttribute("userdetails");
	String[] details=det.split(",");
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Account Settings</title>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="accountsetting.css">
</head>
<body>
	<section class="py-3 my-1">
		<div class="container">
			<h1 class="mb-5">Account Settings</h1>
			<div class="bg-white shadow rounded-lg d-block d-sm-flex">
				<div class="profile-tab-nav border-right">
					<div class="p-4">
						<div class="img-circle text-center mb-3">
							<img src="img/user2.jpg" alt="Image" class="shadow">
						</div>
						<h4 class="text-center"><%=details[6] %></h4>
						
					</div>
					<div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
						<a class="nav-link active" id="account-tab" data-toggle="pill" href="#account" role="tab" aria-controls="account" aria-selected="true">
							<i class="fa fa-home text-center mr-1"></i> 
							Account
						</a>
						<a class="nav-link" id="password-tab" data-toggle="pill" href="#password" role="tab" aria-controls="password" aria-selected="false">
							<i class="fa fa-key text-center mr-1"></i> 
							Password
						</a>
					</div>
				</div>
				<div class="tab-content p-4 p-md-5" id="v-pills-tabContent">
					<form class="tab-pane fade show active" action="./accountStd" id="account" method="post" role="tabpanel" aria-labelledby="account-tab">
						<h3 class="mb-4">Account Settings</h3>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>First Name</label>
								  	<input type="text" name="firstname" class="form-control" value="<%=details[0] %>">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Last Name</label>
								  	<input type="text" name="lastname" class="form-control" value="<%=details[1] %>">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Email</label>
								  	<input type="text" name="email" class="form-control" value="<%=details[2] %>">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Phone number</label>
								  	<input type="text" name="mobile" class="form-control" value="<%=details[3] %>">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Parent Name</label>
								  	<input type="text" name="parentname" class="form-control" value="<%=details[4] %>">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>parent Email</label>
								  	<input type="text" name="parentemail" class="form-control" value="<%=details[5] %>">
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
								  	<label>Bio</label>
									<textarea name="bio" class="form-control" placeholder="Describe yourself here..." rows="3"><% if(!details[8].equals("null")) { %><%=details[8] %><%} %></textarea>
								</div>
							</div>
						</div>
						<div>
							<button class="btn btn-primary">Update</button>
							<span class="btn btn-light" onclick="Cancel()">Cancel</span>
						</div>
					</form>
					<form class="tab-pane fade" id="password" action="./accountStd" method="post" role="tabpanel" aria-labelledby="password-tab">
						<h3 class="mb-4">Password Settings</h3>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Old password</label>
								  	<input id="pass" value="<%=details[7] %>" style="display: none;">
                        			<input type="password" class="form-control" id="oldpass" name="oldpass" oninput="PasswordBlur()">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>New password</label>
								  	<input type="password" class="form-control" id="newpass" name="newpass" disabled>
								</div>
							</div>
						</div>
						<div>
							<button class="btn btn-primary">Update</button>
							<span class="btn btn-light" onclick="Cancel()">Cancel</span>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="accountset.js"></script>
</body>
</html>