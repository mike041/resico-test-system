<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>

<body>
<div class="container-fluid">
    <div class="row-fluid">
        <button class="btn btn-primary" type="button">
            <a href="${pageContext.request.contextPath}/interface/allInterface"> 进入书籍页面</a>
        </button>
        <button class="btn btn-primary" type="button">
            <a href="${pageContext.request.contextPath}/interface/toAddInterface"> 新增书籍页面</a>
        </button>
    </div>
</div>

</body>
</html>
