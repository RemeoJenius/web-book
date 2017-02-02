<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/semantic.css" media="screen"
	title="no title">
<link rel="stylesheet" href="css/global.css" media="screen"
	title="no title">
<script type="text/javascript" src="js/jquery-3.1.1.js">
	
</script>
<script type="text/javascript" src="js/semantic.min.js"></script>
</head>
<body>
	<div class="ui fixed inverted menu">
		<div class="header item">
			<a href="/web-book/"><i class="book icon"></i></a>
		</div>
		<div class="active item">Home</div>
		<div class="ui dropdown item">
			分类 <i class="dropdown icon"></i>
			<div class="menu">
				<div class="item">java</div>
				<div class="divider"></div>
				<div class="item">C</div>
				<div class="divider"></div>
				<div class="item">C++</div>
				<div class="divider"></div>
				<div class="item">C#</div>
				<div class="divider"></div>
				<div class="item">Python</div>
			</div>
		</div>
		<div class="right menu">
			<div class="item">
				<div class="ui transparent inverted icon input">
					<i class="search icon"></i> <input type="text" placeholder="Search">
				</div>
			</div>
			<a class="item">Link</a>
			<s:if test="#session.user!=null"><div class="item text">您好，</div>
					<div class="ui dropdown item">
						${user.username}<i class="dropdown icon"></i>
						<s:if test="#session.user.userType==1">
						<div class="menu">
							<a class="item">我的订单</a>
							<a class="item" href="product_list">我的购物车</a>
							<a class="item">我的收藏</a>
							<a class="item" href="logout">安全退出</a>
						</div>
						</s:if>
						<s:else>
							<div class="menu">
							<a class="item">我的订单</a>
							<a href="addProduct.jsp" class="item">添加商品</a>
							<a class="item" href="product_list">我的购物车</a>
							<a class="item">我的收藏</a>
							<a class="item" href="logout">安全退出</a>
						</div>
						</s:else>
					</div>
			</s:if>
			<s:else>
				<a class="item" href="login.jsp">登录</a>
				<a class="item">注册</a>
			</s:else>

		</div>
	</div>
	<div class="overlay">
		<div class="ui labeled icon vertical menu">
			<a class="item"><i class="twitter icon"></i> Tweet</a> <a
				class="item"><i class="facebook icon"></i> Share</a> <a class="item"><i
				class="mail icon"></i> E-mail</a>
		</div>
	</div>
</body>
</html>