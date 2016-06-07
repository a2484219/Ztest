<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页信息</title>
    <style>
 		.hrstyle{
  			width:400px;
  			align:left;
  			border:10;
  			color:red;
  			hight:2px;
 		}
	</style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> 
	<meta http-equiv="description" content="This is my page">
	<!-- 直接引用bootstrap的样式 -->
	<link rel="stylesheet" href="//apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
	<script type="text/javascript" src="<%= basePath%>js/angular.min.js"></script>
	<script type="text/javascript">
		var app = angular.module('myApp', []);
		app.controller('myCtrl', function($scope,$http) {
	    	$scope.username= "Johny";
	    	/* $http.get("http://localhost/springmvc/test/index.htm")
    			.success(function(response) {
    			$scope.username = "JOHNY";
    		}); */
    		$http({method : 'POST',params : {id:123,username:'jack',password:'123'}, data:{username:'john',password:'27'}, url : "test/index.htm"})
			.success(function(response, status, headers, config){
				//do anything what you want;
				/* alert(response);
				alert("22222");
				window.location="test/index.htm"; */
				//重新加载网页
				//window.location.reload();
			})
			.error(function(response, status, headers, config){
				//do  anything what you want;
				alert("33333");
		});
		});
		
		
		
	</script>
  </head>
  <!-- ng-init优先于script中的$scope.username -->
  <body ng-init="username='John';age=10;cost=20;person={name:'John',psd:'123'};points=[1,2,3,3,5]" ng-app="myApp" ng-controller="myCtrl" style="margin-left:100px" bgcolor="red">
  <br>
  <label>用户信息</label>
  <hr class="hrstyle" align="left">
    <label class="control-label">用户名：</label><input type="text" ng-model='username' class="form-control" placeholder="用户名" style="width:320px"></br>
    <label class="control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label><input type="password" ng-model='password' class="form-control" placeholder="密码" style="width:320px"></br>
	
	<hr class="hrstyle" align="left">
	username:{{username}}</br>
	算法：{{99 + 1}}</br>
	值：{{age * cost}}</br>
	<!-- 就目前，ng-bind类似于{{}}效果 -->
	总价： <span ng-bind="age * cost"></span></p>
	person对象姓名：{{person.name}}</br>
	person对象密码：<span ng-bind="person.psd"></span></p>
	数组元素：{{points[3]}}</br>
	<p>第三个值为 <span ng-bind="points[2]"></span></p>
	
	<!-- 循环数组 -->
	<div ng-app="" ng-init="names=['Jani','Hege','Kai']">
  	<p>使用 ng-repeat 来循环数组</p>
  	<ul>
    <li ng-repeat="x in names">
      {{ x }}
    </li>
  </ul>
  </div>
  <!-- 循环对象 -->
  <div ng-app="" ng-init="names=[
	{name:'Jani',country:'Norway'},
	{name:'Hege',country:'Sweden'},
	{name:'Kai',country:'Denmark'}]">
	
	<p>循环对象：</p>
	<ul>
	  <li ng-repeat="x	in names">
	    {{ x.name + ', ' + x.country }}
	  </li>
	</ul>

</div>
<!-- 校验email是否合法 -->
<form ng-app="" name="myForm">
    Email:
    <input type="email" name="myAddress" ng-model="text">
    <span ng-show="myForm.myAddress.$error.email">不是一个合法的邮箱地址</span>
</form>
<select ng-model="selectedName" ng-options="x for x in names">
</select>

<button class="btn btn-success" ng-click="count = count + 1">点我！</button>

<p>{{ count }}</p>
<hr class="hrstyle" align="left">
<button class="btn btn-success" ng-click="editUser('new')">
<span class="glyphicon glyphicon-user,glyphicon glyphicon-pencil"></span>创建新用户
</button><hr class="hrstyle" align="left">
<table class="table table-striped">
	<tr>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
	</tr>
</table>

<button class="btn btn-primary" ng-click="editUser('new')">
<span class="glyphicon glyphicon-save">nihao</span>
</button>
  </body>
</html>
