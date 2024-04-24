<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login and Sign Up</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


	<!--  로그인  -->
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
                <h2>Login</h2>
                <form action="http://localhost:8080/crud/loginservlet" method = "post">
                    <div class="form-group">
                        <label for="loginUsername">Username</label>
                        
                        <input type="text" name="loginUserid" class="form-control" id="loginUsername" placeholder="Enter username">
                    </div>
                    <div class="form-group">
                    
                        <label for="loginPassword">Password</label>
     <!-- 나중에 type을 password로 바꿔주세용~ 마스킹 되게 -->                   
                        <input type="text" name="loginPassword" class="form-control" id="loginPassword" placeholder="Enter password">
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                </form>
            </div>
            
            
            
            <!-- 회원가입 -->
            <div class="col-md-6">
                <h2>Sign Up</h2>
                <form action="http://localhost:8080/crud/registerservlet" method = "post">
                	<div class="form-group">
                        <label for="signupUsername">User Name</label>
                        <input type="text" name="signupUsername" class="form-control" id="signupUsername" placeholder="Enter user id">
                    </div>
                    <div class="form-group">
                        <label for="signupUsername">User ID</label>
                        <%--LoginServlet.java의  --%>
                        <input type="text" name="signupUserid" class="form-control" id="signupUserid" placeholder="Enter user id">
                    </div>
                    <div class="form-group">
                        <label for="signupPassword">Password</label>
                        <input type="text" name="signupPassword" class="form-control" id="signupPassword" placeholder="Enter password">
                    </div>
                    <button type="submit" class="btn btn-primary">Sign Up</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
