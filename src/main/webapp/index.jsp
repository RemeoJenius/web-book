0<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书城</title>
<link rel="stylesheet" href="css/semantic.css" media="screen"
	title="no title">
<link rel="stylesheet" href="css/index.css" media="screen"
	title="no title">
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/semantic.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript">
	$('.menu .item').tab();
	$('.right.floated.created').click(function() {
		$('.ui.modal').modal('show');
	});
	 function getProductId(value){
		$('.ui.modal').modal('show');

		$('#yes').click(function () {
			$.ajax({
				url:'operating_buyProduct?id='+value,
				dataType:'text',
				success:function(result){
					alert("购买成功");
					window.location.assign('product_list');
				},
				error:function(message){
					alert("购买失败");
					window.location.assign('login.jsp');
				}
			});
		});
	};
	function getProductDeleteId(value){
			$.ajax({
				url:'operating_deleteProduct?id='+value,
				dataType:'text',
				success:function(result){
					alert("删除成功");
					window.location.assign('main');
				},
				error:function(message){
					alert("删除失败");
				}
			});
	};
</script>
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

</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="ui main container">
		<img class="ui image" src="images/2.jpg" alt="" />
		<div class="ui top blue attached tabular menu">
			<a class="item" data-tab="first">促销</a> <a class="item active"
				data-tab="second">热卖</a> <a class="item" data-tab="third">推荐</a>
		</div>
		<div class="ui bottom attached tab segment" data-tab="first">
			<!-- first -->
			<%-- <div class="ui four cards">
			<s:iterator var="product" value="#application.productList">
				<div class="ui relaxed card">
					<div class="image">
						<div class="ui blurring inverted dimmer" id="showContent">
							<div class="content">
								<div class="center">
									<div class="ui teal button">Add shopping cart</div>
								</div>
							</div>
						</div>
						<img src="${product.imageAdress}">
					</div>
					<div class="content">
						<div class="header">${product.title}</div>
						<div class="meta">
							<a href="product_detail?id=${product.id}" class="group">详情</a>
						</div>
						<div class="description">${product.description}</div>
					</div>
					<div class="extra center aligned">
						<div data-rating="4" class="ui star rating"></div>
					</div>
					<div class="extra content">
						<a class="right floated created">收藏</a> <a class="friends"  onclick="getProductId(${product.id});">购买</a>
					</div>
				</div>
				</s:iterator>
			</div> --%>
		</div>
		<div class="ui bottom attached tab segment active" data-tab="second">
			<div class="ui four cards">
			<s:iterator var="product" value="#application.productList">
				<div class="ui relaxed card">
					<div class="image">
						<div class="ui blurring inverted dimmer">
							<div class="content">
								<div class="center">
									<s:if test="#session.user.userType==0">
									<div class="ui teal button" onclick="getProductDeleteId(${product.id});">删除商品</div>
								</s:if>
								<s:else>
									<div class="ui teal button">Add shopping cart</div>
								</s:else>
								</div>
							</div>
						</div>
						<img src="${product.imageAdress}">
					</div>
					<div class="content">
						<div class="header">${product.title}</div>
						<div class="left floated meta">
							<a href="product_detail?id=${product.id}" class="group">详情</a>
						</div>
						<s:if test="#session.user.userType==0">
						<div class="right floated meta">
							<a href="operating_editData?id=${product.id}" class="group">修改</a>
						</div>
						</s:if>
						<div class="description">${product.description}</div>
						<h3 class="ui right floated red header">¥${product.price}</h3>
					</div>
					<div class="extra center aligned">
						<div data-rating="4" class="ui star rating"></div>
					</div>
					<div class="extra content">
						<a class="right floated created">收藏</a> <a class="friends"  onclick="getProductId(${product.id});"> 购买</a>
					</div>
				</div>
				</s:iterator>
			</div>
		</div>
		<div class="ui bottom attached tab segment" data-tab="third">
			<!-- three -->
			<div class="ui four cards">
			<s:iterator var="product" value="#application.productList">
				<div class="ui relaxed card">
					<div class="image">
						<div class="ui blurring inverted dimmer">
							<div class="content">
								<div class="center">
								<s:property value="#session.user.userType"/>
								<s:if test="#session.user.userType==1">
									<div class="ui teal button" onclick="getProductDeleteId(${product.id});">删除商品</div>
								</s:if>
								<s:else>
									<div class="ui teal button">Add shopping cart</div>
								</s:else>
								</div>
							</div>
						</div>
						<img src="${product.imageAdress}">
					</div>
					<div class="content">
						<div class="header">${product.title}</div>
						<div class="meta">
							<a href="product_detail?id=${product.id}" class="group">详情</a>
						</div>
						<div class="description">${product.description}</div>
					</div>
					<div class="extra center aligned">
						<div data-rating="4" class="ui star rating"></div>
					</div>
					<div class="extra content">
						<a class="right floated created">收藏</a> <a class="friends"  onclick="getProductId(${product.id});"> 购买</a>
					</div>
				</div>
				</s:iterator>
			</div>
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
	</div>
	<div class="ui basic modal">
		<i class="close icon"></i>
		<div class="header">Archive Old Messages</div>
		<div class="image content">
			<div class="image">
				<i class="github icon"></i>
			</div>
			<div class="description">
				<p>您去确定购买该商品?</p>
			</div>
		</div>
		<div class="actions">
			<div class="two fluid ui inverted buttons">
				<div class="ui cancel red basic inverted button">
					<i class="remove icon"></i> No
				</div>
				<div id="yes" class="ui ok green basic inverted button">
					<i class="checkmark icon"></i> Yes
				</div>
			</div>
		</div>
	</div>
</body>
</html>
