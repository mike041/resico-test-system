<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bug统计</title>
    <style>
        #new {
            display: inline-block;
            align: "right";
        }
    </style>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container-fluid" align="center">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>bug统计</small>
                </h1>
            </div>

        </div>
    </div>
</div>





<div id="new">
    <form class="form-inline" action="${pageContext.request.contextPath}/gitStatistic/statistic" method="post">
        <div class="form-group">
            <label>开始时间</label>
            <input type="text" class="form-control" name="start">
        </div>
        <div class="form-group">
            <label>结束时间</label>
            <input type="text" class="form-control" name="end">
        </div>
        <button type="submit" class="btn btn-info">查询</button>
    </form>
</div>


<div class="container-fluid ">
    <div class="row-fluid">
        <div class="span12">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>
                        姓名
                    </th>
                    <th>
                        bug数量
                    </th>
                    <th>
                       代码数量
                    </th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="statisticsUser" items="${statistics}">
                    <tr>
                        <td>
                                ${statisticsUser.name}
                        </td>
                        <td>
                                ${statisticsUser.bugNumber}<%--/${statisticsUser.line}*1000--%>
                        </td>
                        <td>
                                ${statisticsUser.line}<%--/${statisticsUser.line}*1000--%>
                        </td>
                        <td>
                                ${statisticsUser.bugNumber/statisticsUser.line*1000}
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