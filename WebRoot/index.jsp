<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>home</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>

</head>

<body>
<div class="iphone">
    <div class="iphone-top">
        <span class="camera"></span>
        <span class="sensor"></span>
        <span class="speaker"></span>
    </div>
    <div class="top-bar"></div>
    <div class="iphone-screen">
        <!-- <img src="img/Awesome-iPhone-Wallpapers.jpg" alt="" /> -->
        <iframe src="http://localhost:8100/?ionicplatform=ios#/tab/home" frameborder="0" width="100%"
                height="100%"></iframe>
    </div>
    <div class="buttons">
        <span class="on-off"></span>
        <span class="sleep"></span>
        <span class="up"></span>
        <span class="down"></span>
    </div>
    <div class="bottom-bar"></div>
    <div class="iphone-bottom">
        <span></span>
    </div>
</div>
</body>
</html>
