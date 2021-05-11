<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>老师登陆</title>

<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
</head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String password="";
	String name="";
	String checked="";
	Cookie[] cookies = request.getCookies();        //取出cookie对象组
	for(int i = 0; cookies != null && i < cookies.length;i++){
		Cookie cookie = cookies[i];       //  取出其中的一个对象，含有name ,value
		if(cookie != null && "name".equals(cookie.getName())){      //获取第一个cookie对象的name
			name = URLDecoder.decode(cookie.getValue(), "UTF-8");//进行解码
			checked = "checked";
		}
		if(cookie != null && "password".equals(cookie.getName())){
			password = cookie.getValue();
		}
	}
%>
<body  background="${pageContext.request.contextPath}/img/p1.jpg" style=" background-repeat:no-repeat ;background-size:100% 100%; background-attachment: fixed;" >
	<div class="login-box">
		<div class="login-logo">
			<a href="all-admin-index.html"><b>成都东软</b>学生在线选课系统</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">老师登陆</p>

			<form action="${pageContext.request.contextPath}/teacher/findTeacherByIdAndPassword"
				method="post">
				<div class="form-group has-feedback">
					<input type="text" name="name" class="form-control" value="<%=name%>"
						placeholder="姓名"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password" class="form-control" value="<%=password%>"
						placeholder="密码"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label><input type="checkbox" value="yes" <%=checked%> name="checked"> 记住 </label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
					</div>
					<!-- /.col -->
				</div>
			</form>
			<a href="adminLogin.jsp">
				<input type="button" value="管理员登陆"/>
			</a>
			<a href="stuLogin.jsp">
				<input type="button" value="学生登陆"/>
			</a><br>
			<a href="#">忘记密码</a>



		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.2.3 -->
	<!-- Bootstrap 3.3.6 -->
	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
</body>

</html>