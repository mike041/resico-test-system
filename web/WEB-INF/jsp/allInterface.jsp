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
                    <small>书籍列表-显示所有书籍</small>
                </h1>
            </div>

        </div>
    </div>
</div>

<div class="container-fluid ">
    <div class="row-fluid">
        <div class="span12">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>
                        编号
                    </th>
                    <th>
                        名称
                    </th>
                    <th>
                        请求类型
                    </th>
                    <th>
                        协议类型
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="interface" items="${interfaceList}">
                    <tr>
                        <td>
                                ${interface.id}
                        </td>
                        <td>
                                ${interface.name}
                        </td>
                        <td>
                                ${interface.requestType}
                        </td>
                        <td>
                                ${interface.protocolType}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/interface/toUpdateInterface?id=${interface.id}">修改</a>
                            &nbsp; | &nbsp;
                            <a href="${pageContext.request.contextPath}/interface/deleteInterface/${interface.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


</body>
</html>