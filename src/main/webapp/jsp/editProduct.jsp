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
<link rel="stylesheet" href="css/uploadPreview.css" media="screen"
	title="no title">
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/semantic.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/uploadPreview.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.ui.form').form({
			fields : {
				title : {
					rules : [ {
						type : 'empty',
						prompt : '商品名称不能为空'
					} ]
				},
				introduction : {
					rules : [ {
						type : 'empty',
						prompt : '商品简介不能为空'
					} ]
				},
				description : {
					rules : [ {
						type : 'empty',
						prompt : '商品描述不能为空'
					} ]
				},
				price : {
					rules : [ {
						type : 'empty',
						prompt : '商品价格不能为空'
					} ]
				}
			}
		});
	});
</script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="ui main container">
		<form class="ui form" method="post" action="operating_editProduct">
			<div class="ui two column grid">
				<div class="column" style="padding-top: 6rem;">
					<h4 class="ui dividing header">Shipping Information</h4>
					<div class="required field">
						<label>商品名称</label>
						<div class="two fields">
							<div class="field">
								<input id="title" type="text" name="title"
									value="${product.title}" />
							</div>
						</div>
					</div>
					<div class="two fields">
						<div class="field">
							<label>商品类型</label> <select class="ui fluid search dropdown"
								name="typeId">
								<option value="">热卖</option>
								<option value="1">促销</option>
								<option value="2">推荐</option>
								<option value="3">热卖</option>
							</select>
						</div>
					</div>
				</div>
				<div class="column">
					<div id="demo">
						<div class="image_container">
							<img src="${product.imageAdress}" style="max-height:400px;" alt="" />
						</div>
					</div>
				</div>
			</div>
			<h4 class="ui dividing header">商品备注</h4>

			<div class="fields">
				<div class="eight wide field">
					<label>Product Introduction</label>
					<div class="field">
						<input id="introduction" type="text" name="introduction"
							value="${product.introduction}" />
					</div>
				</div>
				<div class="eight wide field">
					<div class="ui error message">
						<div class="header">不好意思</div>
						<p>请填写商品名称</p>
					</div>
				</div>
			</div>
			<h4 class="ui dividing header">商品描述</h4>
			<div class="field">
				<label>Product Description:</label>
				<div class="field">
					<textarea id="description" rows="5" name="description"
						>${product.description}</textarea>
				</div>
			</div>
			<div class="field">
				<label>价格</label> <input type="text" name="price"
					value="${product.price}" />
			</div>
			<input class="ui button submit" type="submit" value="Submit Order" />
		</form>
	</div>
</body>