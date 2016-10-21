<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link rel="stylesheet" href="css/semantic.css" media="screen"
	title="no title">
<link rel="stylesheet" href="css/product_list.css" media="screen"
	title="no title">
<script type="text/javascript" src="js/jquery-3.1.1.js">

</script>
<script type="text/javascript" src="js/semantic.min.js"></script>
<style>
body {
	padding: 1em;
}

.ui.menu {
	margin: 3em 0em;
}

.ui.menu:last-child {
	margin-bottom: 110px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('.ui.menu .ui.dropdown').dropdown({
			on : 'hover'
		});
		$('.ui.menu a.item').on('click', function() {
			$(this).addClass('active').siblings().removeClass('active');
		});
	});
	$(document).ready(function() {
		$('.special.card .image').dimmer({
			on : 'hover'
		});
		$('.star.rating').rating();
		$('.card .dimmer').dimmer({
			on : 'hover'
		});
	});
	$(document).ready(function() {

		// fix main menu to page on passing
		$('.main.menu').visibility({
			type : 'fixed'
		});
		$('.overlay').visibility({
			type : 'fixed',
			offset : 80
		});

		// lazy load images
		$('.image').visibility({
			type : 'image',
			transition : 'vertical flip in',
			duration : 500
		});

		// show dropdown on hover
		$('.main.menu  .ui.dropdown').dropdown({
			on : 'hover'
		});
	});
</script>
</head>
<body>
	<div class="ui fixed inverted menu">
		<div class="header item">
			<i class="book icon"></i>
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
						<div class="menu">
							<a class="item">我的积分</a>
							<a class="item" href="product_list">我的购物车</a>
							<a class="item">收礼人</a>
							<a class="item">我的收藏</a>
							<a class="item" href="logout">安全退出</a>
						</div>
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
	<div class="ui main container">
		<h2 class="header">
			<i class="cart icon"></i> shopping cart
		</h2>
		<s:iterator var="product" value="#session.productList">
		<div class="ui bottom attached container">
			<div class="ui grid segment">
				<div class="three wide column">
					<div class="ui small images">
						<img src="${product.imageAdress}" alt="" />
					</div>
				</div>
				<div class="ten wide column">
					<h4>${product.title}</h4>
					<p>${product.description}</p>
				</div>
				<s:if test="#session.message!=null">
				<div class="three wide column">
					<div class="ui two bottom attached buttons">
						<div class="ui red button">购买</div>
						<div class="ui button">删除</div>
					</div>
				</div>
				</s:if>
				<s:else>
					<div class="ui segment">
						<h2>您的购物车为空</h2>
					</div>
				</s:else>
			</div>
		</div>
		</s:iterator>
	</div>
	<div class="ui basic modal">
		<i class="close icon"></i>
		<div class="header">Archive Old Messages</div>
		<div class="image content">
			<div class="image">
				<i class="github icon"></i>
			</div>
			<div class="description">
				<p>Your inbox is getting full, would you like us to enable
					automatic archiving of old messages?</p>
			</div>
		</div>
		<div class="actions">
			<div class="two fluid ui inverted buttons">
				<div class="ui cancel red basic inverted button">
					<i class="remove icon"></i> No
				</div>
				<div id="yes" class="ui ok green basic inverted button">
					<i class="checkmark icon" id="yes"></i> Yes
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	$('.menu .item').tab();
	$('.ui.red.button').click(function() {
		$('.ui.modal').modal('show');
	});
		$('#yes').click(function () {
			$.ajax({
				url:'operating_delete',
				dataType:'json',  
				success:function(response){
					alert(typeof(response.message));
					// window.location.assign('product_list');
				},
				error:function(message){
					alert("删除失败");
				}
			});
	});
</script>
</html>
