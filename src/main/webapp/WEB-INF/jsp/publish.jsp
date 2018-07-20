<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/6
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>活动发布界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>

                    <small>发布界面</small>
                </h1>
            </div>
        </div>
    </div>


    <form method="get" action="<%=appPath%>/mountaineering/add">

        活动标题： <input type="text" value="" name="title"> <br/>
        活动价格： <input type="price" value="" name="price"> <br/><br/><br/>
        头部图片：<input type="text" value="" name="imagesBanner" style="height: 100px"> <br/><br/><br/>
        上车地点：<input type="text" value="" name="loaction"> <br/>
        特色线路：<input type="text" value="" name="lineFeature"> <br/>
        风景指数：<input type="number" value="" name="star"> <br/>
        活动领队：<input type="text" value="" name="leaderName"> <br/>
        报名列表：<input type="text" value="" name="userJoin"> <br/>
        活动优惠：<input type="text" value="" name="specialOffers"> <br/><br/><br/>


        一段描述：<input type="text" value="" name="desc" style="height: 50px"> <br/><br/>

        结束日期：<input type="date" value="" name="closeDate"> <br/><br/>

        底部图片：<input type="text" value="" name="imagesMore" style="height: 100px"> <br/><br/><br/>

        <input type="submit" value="提交">

    </form>


    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="https://code.jquery.com/jquery.js"></script>
</body>
</html>