<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title></title>
    <%--<style type="text/css">--%>
    <%--body {--%>
    <%--font-family: pingfang sc light;--%>
    <%--}--%>

    <%--.center {--%>
    <%--text-align: center;--%>
    <%--width: 100%;--%>
    <%--}--%>


    <%--</style>--%>
    <%--<link rel="stylesheet" type="text/css" href="/css/commen.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="/static/css/style.css">--%>


    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            text-align: left;
            word-break: break-all;
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
        }

        body {
            font-family: pingfang sc light;
        }

        .center {
            text-align: center;
            width: 100%;
        }

        table {
            border-collapse: collapse;
        }


    </style>


</head>

<style>
    td , tr ,th{
        border: 1px solid #000000;
        font-size: 14px;
        padding: 5px;
    }

    th{
        text-align: center;
    }

</style>


<body>


<div class="container">


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>品种序号</th>
                    <th>品种</th>
                    <th>报价序号</th>
                    <th>报价人</th>
                    <th>地区</th>
                    <th>规格</th>
                    <th>报价日期</th>
                    <th>上车价</th>
                    <th>预估到岸价</th>
                    <th>状态</th>
                </tr>
                </thead>
                <tbody>

                <%--<tr>--%>
                    <%--<td>${fild1}</td>--%>
                    <%--<td>${fild2}</td>--%>
                    <%--<td>${fild3}</td>--%>
                    <%--<td>${fild4}</td>--%>
                    <%--<td>${fild5}</td>--%>
                    <%--<td>${fild6}</td>--%>
                    <%--<td>${fild7}</td>--%>
                    <%--<td>${fild8}</td>--%>
                    <%--<td>${fild9}</td>--%>
                    <%--<td>${fild10}</td>--%>
                <%--</tr>--%>

                <tr>
                    <td>1</td>
                    <td>香樟</td>
                    <td>1</td>
                    <td>我良/15260032590</td>
                    <td>江苏 镇江</td>
                    <td>米径 ； 3 高度： 4</td>
                    <td>2017-12-26 16:59:44</td>
                    <td>33</td>
                    <td>666</td>
                    <td>未采用</td>
                </tr>

                <tr>
                    <td>1</td>
                    <td>香樟</td>
                    <td>1</td>
                    <td>我良/15260032590</td>
                    <td>江苏 镇江</td>
                    <td>米径 ； 3 高度： 4</td>
                    <td>2017-12-26 16:59:44</td>
                    <td>33</td>
                    <td>666</td>
                    <td>未采用</td>
                </tr>

                <tr>
                    <td>1</td>
                    <td>香樟</td>
                    <td>1</td>
                    <td>我良/15260032590</td>
                    <td>江苏 镇江</td>
                    <td>米径 ； 3 高度： 4</td>
                    <td>2017-12-26 16:59:44</td>
                    <td>33</td>
                    <td>666</td>
                    <td>未采用</td>
                </tr>

                <tr>
                    <td>1</td>
                    <td>香樟</td>
                    <td>1</td>
                    <td>我良/15260032590</td>
                    <td>江苏 镇江</td>
                    <td>米径 ； 3 高度： 4</td>
                    <td>2017-12-26 16:59:44</td>
                    <td>33</td>
                    <td>666</td>
                    <td>未采用</td>
                </tr>

                </tbody>


                <%--<tbody>--%>
                <%--<c:forEach var="book" items="${requestScope.get('list')}" varStatus="status">--%>
                <%--<tr>--%>
                <%--<td>${book.bookId}</td>--%>
                <%--<td>${book.name}</td>--%>
                <%--<td>${book.number}</td>--%>
                <%--<td>--%>
                <%--<a href="<%=appPath%>/book/detail/${book.bookId}">详情</a>--%>
                <%--<a href="<%=appPath%>/book/del/${book.bookId}">删除</a>--%>
                <%--</td>--%>

                <%--<td><img src="${book.url}" style="height: 100px ; width: 100px" id="viewImg3" name="viewImg3">--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--</c:forEach>--%>
                <%--</tbody>--%>
            </table>
        </div>
    </div>

    <br/>
    <br/>
    <br/>

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


<!--第一页开始-->
<div class="page">
    <div class="center"><p>${templateName}</p></div>
    <div><p>iText官网:${ITEXTUrl}</p></div>
    <div><p>FreeMarker官网:${freeMarkerUrl}</p></div>
    <div><p>JFreeChart教程:${JFreeChartUrl}</p></div>
    <div>列表值:</div>
    <div>
        <#list scores as item>
            <div><p>${item}</p></div>
        </#list>
    </div>
</div>
<!--第一页结束-->
<!---分页标记-->
<span style="page-break-after:always;"></span>
<!--第二页开始-->
<div class="page">
    <div>第二页开始了</div>
    <!--外部链接-->
    <p>百度图标</p>
    <div>
        <img src="${imageUrl}" alt="百度图标" width="270" height="129"/>
    </div>
    <!--动态生成的图片-->
    <p>气温变化对比图</p>
    <div>
        <img src="${picUrl}" alt="我的图片" width="500" height="270"/>
    </div>
</div>


<!--第二页结束-->
</body>
</html>