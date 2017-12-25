<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <meta charset="utf-8">
</head>


<script type="text/javascript">
    var ws;


    function hello() {
        var userName = document.getElementById("name").value;
//        ws = new WebSocket("ws://127.0.0.1:81/WebsocketTest/hello");
        ws = new WebSocket("ws://127.0.0.1:81/hello/" + userName);
//        ws = new WebSocket("ws://localhost:81/hello-ssm/hello");
        ws.onopen = function (event) {
            console.log(event);
        };


        ws.onmessage = function (event) {
            console.log(event.data);
//            var dv = document.getElementById("dv");
            var content = document.getElementById("content");
            content.text += "\n" + event.data + "\n";
            content.value += "\n" + event.data + "\n";
//            dv.innerHTML += "收到回复：\n" + event.data + "\n";
        };

        /*关闭socket*/
        ws.onclose = function () {
            console.log("关闭 close")
        };


    };

    function subsend() {
        var msg = document.getElementById("msg").value;
        ws.send(msg);
        document.getElementById("msg").value = "";
    }

    function close() {
        ws.close();
    }


</script>

<body>
<h2>SSM_BookSystem --- V0</h2>
简单的查询、删除等基础功能 index
<br/>
日期：2017-05-01 22:25:37
<br/>
作者：hisenyuan
<br/>
网站：<a href="hisen.me" target="_blank">hisen.me</a>
<br/><br/><br/><br/>


<%--192.168.1.127:81--%>
<br/><br/>
<a href="http://192.168.1.127:81/book/push/83e5cb7bdda14d49b5ca16b1197c8134" target="_blank">推送</a>
<%--<a href="http://localhost:81/book/push/955a53481d514a3eb424c7e74463f03a" target="_blank">推送</a>--%>
<%--<a href="http://localhost:81/book/push/83e5cb7bdda14d49b5ca16b1197c8134" target="_blank">推送</a>--%>
<br/><br/>

图书系统：<a href="<%=appPath%>/book/list">点击前往</a>
<%--图书系统：<a href="add.jsp">点击前往</a>--%>


<div id="dv"/>

输入用户名：<input type="text" id="name" name="name"/>
<br/>
<br/>
<input type="button" value="连接1" onclick="hello()"/>
<input type="text" id="msg"/><input type="button" onclick="subsend()" value="发送"/>

<input type="button" value="关闭" onclick="close()"/>

<div>

    <textarea name="aa" id="content" cols="30" rows="10" style="width: 500px ; height: 500px;">

    </textarea>


</div>

</body>
</html>


评论 （通知）
点赞 取消点赞 删除评论 （message）


messageType = moments;//消息通知类型
momentsId = 83e5cb7bdda14d49b5ca16b1197c8134;//
option = add;//点赞 取消点赞 评论 删除评论 add del
sourceId = 459c3b5a1c4b4ebfba88fe9272c73243; //目标源id 评论id or 点赞id
type = reply; // 评论 reply 点赞thumbUp










