<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/6
  Time: 20:10
  note: 使用bootstrap输出后台返回的requestScope对象
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>图书列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script src="local/communication/static/jquery.min.js" charset="utf-8"></script>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->


</head>


<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    HiSEN
                    <small>图书管理系统 - by ssm基础框架</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li class="active"><a href="<%=appPath%>/book/list">首页</a></li>
                <li><a href="<%=appPath%>/book/detail/10">图书具体信息</a></li>
                <li><a href="<%=appPath%>/add.jsp">添加图书信息</a></li>
                <li class="disabled"><a href="#">信息</a></li>
            </ul>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>图书列表
                    <small>显示当前图书库存信息</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>图书编号</th>
                    <th>图书名字</th>
                    <th>图书数量</th>
                    <th>操作</th>
                    <th>图片</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${requestScope.get('list')}" varStatus="status">
                    <tr>
                        <td>${book.bookId}</td>
                        <td>${book.name}</td>
                        <td>${book.number}</td>
                        <td>
                            <a href="<%=appPath%>/book/detail/${book.bookId}">详情</a>
                            <a href="<%=appPath%>/book/del/${book.bookId}">删除</a>
                        </td>

                        <td><img src="${book.url}" style="height: 100px ; width: 100px" id="viewImg3" name="viewImg3">
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


    <img src="http://169.254.162.222:81/upload/image_20171206134835_0.jpg" id="viewImg2">


    <%--inherit  直接放到底部了--%>

    <!-- 放大后的图片 -->
    <div id="outerdiv"
         style="position:fixed;top:0%;left:0%;background:rgba(0,0,0,0.7);width:200%;height:200%;display:none;text-align: center ; padding-left: 25%   ;    "
         ;>
        <div id="innerdiv" style="position:absolute;width:auto;height:auto;">
            <img id="bigimg" style="border:5px solid #fff;width: auto;;height:auto; " src=""/>
        </div>
    </div>


</div>


</body>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>


<script defer language="javascript">

    //图片放大
    $(function () {
//        $("#viewImg2").click(function () {
        $("img[name='viewImg3']").click(function () {
            var _this = $(this);//将当前的pimg元素作为_this传入函数
            imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);
        });
        $("#viewImg2").click(function () {
            var _this = $(this);//将当前的pimg元素作为_this传入函数
            imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);
        });
    });


    function imgShow(outerdiv, innerdiv, bigimg, _this) {
        var src = _this.attr("src");//获取当前点击的pimg元素中的src属性
        $('#outerdiv').attr('display', 'block');
        $(bigimg).attr("src", src);//设置#bigimg元素的src属性
        $(outerdiv).fadeIn("fast");

        $(outerdiv).click(function () {//再次点击淡出消失弹出层
            $(this).fadeOut("fast");
        });
    }


</script>


</html>