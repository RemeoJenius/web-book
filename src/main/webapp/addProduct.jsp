<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品添加</title>
<link rel="stylesheet" href="css/semantic.css" media="screen"
	title="no title">
<link rel="stylesheet" href="css/global.css" media="screen"
	title="no title">
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/semantic.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="ui main container">
		<form class="ui form" method="post" action="operating_addProduct">
			<div class="ui two column grid">
				<div class="column">
					<h4 class="ui dividing header">Shipping Information</h4>
					<div class="field">
						<label>商品名称</label>
						<div class="two fields">
							<div class="field">
								<input id="productName" type="text" name="productName" >
							</div>
						</div>
					</div>
					<div class="two fields">
						<div class="field">
							<label>商品类型</label> <select class="ui fluid search dropdown"
								name="card[expire-month]">
								<option value="">热卖</option>
								<option value="1">促销</option>
								<option value="2">推荐</option>
								<option value="3">热卖</option>
							</select>
						</div>
					</div>
				</div>
				<div class="column">
					<!-- <div class="ui image">
                        <img src="images/python.jpg" alt="" />
                    </div> -->
				</div>
			</div>
			<h4 class="ui dividing header">商品备注</h4>

			<div class="fields">
				<div class="eight wide field">
					<label>Product Introduction</label>
					<div class="field">
						<input id="introduction" type="text" name="introduction">
					</div>
				</div>
			</div>
			<h4 class="ui dividing header">商品描述</h4>
			<div class="field">
				<label>Product Description:</label>
				<div class="field">
					<textarea id="description" rows="5" name="description"></textarea>
				</div>
			</div>
			<div class="ui button submit" tabindex="0">Submit Order</div>
		</form>
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
	$('.ui.button.submit').click(function() {
		if($('#productName').val() != '' && $('#introduction').val() != '' && $('#description').val() != '')
			{$('.ui.basic.modal')
		  .modal('show')
		;}
	});
	$('.ui.checkbox').checkbox();
	$('#yes').click(function() {
		$.ajax({
			url : 'operating_addProduct',
			dataType : 'json',
			success : function(response) {
				alert("添加成功");
				 window.location.assign('/web-book/');
			},
			error : function(message) {
				alert("添加失败");
			}
		});
	});
	$(document).ready(function() {
		$('.ui.form').form({
			fields : {
				productName : {
					identifier : 'productName',
					rules : [ {
						type : 'empty',
						prompt : 'Please enter your productName'
					}, {
						type : 'productName',
						prompt : 'Please enter a valid productName'
					} ]
				},
				introduction : {
					identifier : 'introduction',
					rules : [ {
						type : 'empty',
						prompt : 'Please enter your introduction'
					}, {
						type : 'introduction',
						prompt : 'Please enter a valid introduction'
					} ]
				},
				description : {
					identifier : 'description',
					rules : [ {
						type : 'empty',
						prompt : 'Please enter your description'
					}, {
						type : 'description',
						prompt : 'Please enter a valid description'
					} ]
				}
				
			}
		});
	});
	
</script>

</html>
