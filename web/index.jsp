<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
<div class="container-fluid">
    <div class="row-fluid">
        <button class="btn btn-warning" type="button">
            <a href="${pageContext.request.contextPath}/interface/listPage"> 进入接口页面</a>
        </button>
        <button class="btn btn-warning" type="button">
            <a href="${pageContext.request.contextPath}/testcase/listPage"> 进入用例页面</a>
        </button>
    </div>
</div>

</body>
</html>
