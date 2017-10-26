<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="likole">
    <meta name="keyword" content="IMUDGES">

    <title>注册 -- IMUDGES成员管理系统</title>

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
	  	
		      <form class="form-login" action="getRegisterMail" method="post">
		        <h2 class="form-login-heading">注册</h2>
		        <div class="login-wrap">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="邮箱" aria-describedby="basic-addon2" name="mail" required>
						<input type="hidden" name="csrf" value="<s:property value="csrf" />">
						<span class="input-group-addon" id="basic-addon2">@imudges.com</span>
					</div>
					<br>
		            <button class="btn btn-theme btn-block" type="submit" id="submit"><i class="fa fa-envelope-o fa-fw"></i>发送注册链接</button>
		            <hr>
		            <div class="registration">
		                已经拥有帐号?<br/>
		                <a class="" href="../login/">
		                    直接登陆
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
        $(
		);
    </script>

  </body>
</html>
