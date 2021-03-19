<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用例展示</title>
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
                    <small>用例列表-显示所有用例</small>
                </h1>
            </div>

        </div>
    </div>
</div>


<a class="btn btn-info active" display="inline" role="button"
   href="${pageContext.request.contextPath}/testcase/addPage">
    新增用例页面</a>


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
                        千行bug率
                    </th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="user" items="${statistics}">
                    <tr>
                        <td>
                                ${user.name}
                        </td>
                        <td>
                                ${user.bugNumber}/${user.line}*1000
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