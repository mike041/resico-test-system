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
   href="${pageContext.request.contextPath}/testcase/${testcaseId}/interfaceInstance">
    新增接口实例</a>


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
                        接口名称
                    </th>
                    <th>
                        接口地址
                    </th>

                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="interfaceInstanceDTO" items="${interfaceInstanceDTOList}">
                    <tr>
                        <td>
                                ${interfaceInstanceDTO.id}
                        </td>
                        <td>
                                ${interfaceInstanceDTO.interfaceName}
                        </td>
                        <td>
                                ${interfaceInstanceDTO.instanceData}
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