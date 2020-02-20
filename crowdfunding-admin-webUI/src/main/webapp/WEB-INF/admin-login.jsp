<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="keys" content="">
<meta name="author" content="">
<title>❤汇聚点滴的力量，成就非凡的伟业❤</title>
<base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
<style>
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<div>
					<a class="navbar-brand" href="index.html" style="font-size: 32px;">尚筹网-创意产品众筹平台</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">

		<form action="admin/do/login.html" class="form-signin" role="form" method="post">
			<h2 class="form-signin-heading">
				<i class="glyphicon glyphicon-log-in"></i> 管理员登录
			</h2>
			<p>${requestScope.MESSAGE }</p>
			<div class="form-group has-success has-feedback">
				<input 
					type="text"
					name="loginAcct"
					class="form-control" 
					id="inputSuccess4"
					placeholder="请输入登录账号" 
					autofocus>
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<input 
					type="text" 
					name="userPswd"
					class="form-control" 
					id="inputSuccess4"
					placeholder="请输入登录密码" 
					style="margin-top: 10px;">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<button class="btn btn-lg btn-success btn-block">登录</button>
		</form>
	</div>
</body>
</html>