<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改接口</small>
                </h1>
            </div>

        </div>
    </div>
</div>

<form action="${pageContext.request.contextPath}/interface/updateInterface" method="post">

    <%--前端传递隐藏域--%>
    <input type="hidden" name="id" value="${interface.id}">
    <div class="form-group">
        <label>接口名称</label>
        <input type="text" class="form-control" name="name" value="${interface.name}">
    </div>
    <div class="form-group">
        <label>请求类型</label>
        <input type="text" class="form-control" name="requestType" value="${interface.requestType}">
    </div>
    <div class="form-group">
        <label>协议类型</label>
        <input type="text" class="form-control" name="protocolType" value="${interface.protocolType}">
    </div>
    <button type="submit" class="btn btn-default">修改</button>
</form>
</body>
</html>