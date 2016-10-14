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
<link rel="stylesheet" href="css/product_view.css" media="screen"
	title="no title">
<script type="text/javascript" src="js/jquery-3.1.1.js">
	
</script>
<script type="text/javascript" src="js/semantic.min.js"></script>
<style>
<
style>body {
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
			<div class="item input" >
				<div class="ui transparent inverted icon input">
					<i class="search icon"></i> <input type="text" placeholder="Search">
				</div>
			</div>
			<a class="item Link">Link</a>
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
	<div class="ui grid view">
		<div class="four wide column"></div>
		<div class="four wide column">
			<div class="ui left floated medium image">
				<a class="ui right red corner label"> <i class="heart icon"></i>
				</a> <img class="ui images view" src="${product.imageAdress}" />
			</div>
		</div>
		<div class="four wide column">
			<div class="ui card view">
				<div class="content">
					<div class="header">${product.title}</div>
					<div class="description">
						<p class="ui p">${product.description}</p>
					</div>
					<div class="ui divider"></div>
					<span class="left floated">价格：</span> <span
						class="big left floated">¥${product.price}</span>
				</div>
				<div class="ui two bottom attached buttons">
					<div class="red ui button">购买</div>
					<div class="ui red inverted button">加入购物车</div>
				</div>
			</div>
		</div>
		<div class="four wide column"></div>
	</div>
	<div class="ui vertical very padded black segment ">
		<div class="ui grid">
			<div class="four wide column">
				<i class="massive book icon"></i>
			</div>
			<div class="four wide column">
				<div class="ui vertical  text menu">
					<div class="item">
						<h3 class="ui header ">Company</h3>
					</div>
					<div class="item">Address:CN</div>
					<div class="item">Tel:010-666666</div>
					<div class="item">Fax:010-666666</div>
				</div>
			</div>
			<div class="four wide column">
				<div class="ui vertical  text menu">
					<div class="item">
						<h3 class="ui header ">Company</h3>
					</div>
					<div class="item">Address:CN</div>
					<div class="item">Tel:010-666666</div>
					<div class="item">Fax:010-666666</div>
				</div>
			</div>
			<div class="four wide column">
				<div class="ui vertical  text menu">
					<div class="item">Designed by</div>
					<div class="item">
						<h3 class="ui header logo">Munglecoding</h3>
					</div>
				</div>
			</div>

		</div>
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
				<div class="ui ok green basic inverted button" id="yes">
					<i class="checkmark icon"></i> Yes
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$('.menu .item').tab();
	$('.red.ui.button').click(function() {
		$('.ui.modal').modal('show');
	});
	$('#yes').click(function () {
		$.ajax({
			url:'buy',
			dataType:'text',
			success:function(result){
				alert("购买成功");
			},
			error:function(message){
				alert("购买失败");
			}
		});
	});
</script>

</html>