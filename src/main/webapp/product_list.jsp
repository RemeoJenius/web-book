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
	var o;
	function getProductId(value,messages){
		$('#messages').html('你确定要'+messages+"吗？");
		$('.ui.basic.modal')
		  .modal('show');
		o = value;
	};
	function chufa() {
		var messages = $('#messages').html();
		var set ;
		if (messages.indexOf("购买")>0)
			{
				set='buy';
			}
		else{
			set = 'delete';
		}
		
		$.ajax({
			url:'operating_'+set+'?id='+o,
			dataType:'text',  
			success:function(result){
				alert("删除成功");
				window.location.assign('product_list');
			},
			error:function(message){
				alert("删除失败");
			}
		});
	};
</script>
</head>
<body class="dimmable">
	<jsp:include page="head.jsp"></jsp:include>
	<div class="ui main container">
		<h2 class="ui header">
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
					<h4>购买时间：${product.buyTimeFormat}</h4>
					<h4>购买价格：¥${product.price}</h4>
				</div>
				<s:if test="#session.message!=null">
				<div class="three wide column">
					<div class="ui two bottom attached buttons">
						<div class="ui red button" onclick="getProductId(${product.id},'购买');">购买</div>
						<div class="ui button" onclick="getProductId(${product.id},'删除');">删除</div>
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
  <div class="header">
    Archive Old Messages
  </div>
  <div class="image content">
    <div class="image">
      <i class="archive icon"></i>
    </div>
    <div class="description">
      <p id="messages"></p>
    </div>
  </div>
  <div class="actions">
    <div class="two fluid ui inverted buttons">
      <div class="ui cancel red basic inverted button">
        <i class="remove icon"></i>
        No
      </div>
      <button class="ui ok green basic inverted button" onclick="chufa();">
        <i class="checkmark icon"></i>
        Yes
      </button>
    </div>
  </div>
</div>

</body>
<script type="text/javascript">
	$('.menu .item').tab();
	$('.ui.red.button').click(function() {
		$('.ui.modal').modal('show');
	});
</script>
</html>