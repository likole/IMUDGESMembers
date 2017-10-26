<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="likole">
    <meta name="keyword" content="IMUDGES">

    <title>IMUDGES成员管理系统</title>

    <!-- Bootstrap core CSS -->
    <link href="../assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="../assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="../assets/css/style.css" rel="stylesheet">
    <link href="../assets/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" action="login" method="post">
		        <h2 class="form-login-heading">登录</h2>
		        <div class="login-wrap">
		            <input type="email" name="username" class="form-control" placeholder="邮箱(非联盟邮箱)" autofocus required>
		            <br>
		            <input type="password" name="password" class="form-control" placeholder="密码" required>
		            <br>
		            <button class="btn btn-theme btn-block"  type="submit"><i class="fa fa-lock"></i>登录</button>
		            <hr>
		            <div class="registration">
		                还没有帐号?<br/>
		                <a class="" href="../register/">
		                    创建一个帐号
		                </a>
		            </div>
		        </div>
		      </form>	  	
	  	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="../assets/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("../assets/img/login-bg.jpg", {speed: 500});
    </script>

  </body>
</html>
