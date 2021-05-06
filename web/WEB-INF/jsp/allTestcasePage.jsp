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
    <form class="form-inline" action="${pageContext.request.contextPath}/testcase/listPage" method="post">
        <div class="form-group">
            <label>用例名称</label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="form-group">
            <label>用例分组</label>
            <input type="text" class="form-control" name="groupId">
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
                        编号
                    </th>
                    <th>
                        用例名称
                    </th>
                    <th>
                        分组名称
                    </th>

                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="testcase" items="${testcaseList}">
                    <tr>
                        <td>
                                ${testcase.id}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/testcase/${testcase.id}"> ${testcase.name}</a>

                        </td>

                        <td>
                                ${testcase.groupName}
                        </td>

                        <td>
                                <%--
                               <a href="${pageContext.request.contextPath}/testcase/updatePage?id=${testcase.id}">修改</a>
                               &nbsp; | &nbsp;
                               <a href="${pageContext.request.contextPath}/interface/delete/${interfaceDTO.id}">删除</a>
                                   --%>
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