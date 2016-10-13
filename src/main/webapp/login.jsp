<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" href="css/semantic.css" media="screen"
	title="no title">
<script type="text/javascript" src="js/jquery-3.1.1.js">
	
</script>
<script type="text/javascript" src="js/semantic.min.js"></script>
<style type="text/css">
body {
	background-color: #DADADA;
}

body>.grid {
	height: 100%;
}

.image {
	margin-top: -100px;
}

.column {
	max-width: 450px;
}
</style>
<script>
	$(document).ready(function() {
		$('.ui.form').form({
			fields : {
				email : {
					identifier : 'email',
					rules : [ {
						type : 'empty',
						prompt : 'Please enter your e-mail'
					}, {
						type : 'email',
						prompt : 'Please enter a valid e-mail'
					} ]
				},
				password : {
					identifier : 'password',
					rules : [ {
						type : 'empty',
						prompt : 'Please enter your password'
					}, {
						type : 'length[6]',
						prompt : 'Your password must be at least 6 characters'
					} ]
				}
			}
		});
	});
</script>
</head>
<body>
	<div class="ui middle aligned center aligned grid">
		<div class="column">
			<h2 class="ui teal image header">
				<i class="book icon"></i>
				<div class="content">Log-in to your account</div>
			</h2>
			<form id="loginForm" class="ui large form" action="login_login"
				method="post">
				<div class="ui stacked segment">
					<div class="field">
						<div class="ui left icon input">
							<i class="user icon"></i> <input id="un" type="text"
								name="username" placeholder="username">
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i> <input id="pwd" type="password"
								name="password" placeholder="Password">
						</div>
					</div>
					<div class="ui fluid large teal submit button"
						onchange="checkLogin();">Login</div>
				</div>

				<s:if test="#request.message!=null">
					<div class="ui message">
						<div class="ui red inverted  segment"><i class="big warning white icon"></i>${attr.message}</div>
					</div>
				</s:if>
			</form>
		</div>
	</div>

</body>
<script type="text/javascript">
	/* function checkLogin() {
		var loginForm = util.get('loginForm');
		var userName = loginForm['userName'];
		var password = loginForm['password'];
		$.ajax({
			type : 'get',
			url : 'login_login?username=' + userName+'&password='+password,
			dataType : 'text',
			success : function(result) {
				loading.hide();
				location.href = '/';
			},
			error :function(result) {
				alter("登录失败");
			
		}); 
	}
	 */
</script>
</html>