<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.ResourceBundle" %>
<%
    String appPath = request.getContextPath();
//    ResourceBundle res = ResourceBundle.getBundle("config.properties");
    ResourceBundle res = ResourceBundle.getBundle("config");
//  ResourceBundle res = ResourceBundle.getBundle("config.istest");
%>


<html>
<head>
    <meta charset="utf-8">
</head>


<script type="text/javascript">
    var ws;


    function hello() {
        var userName = document.getElementById("name").value;
//        ws = new WebSocket("ws://127.0.0.1:81/WebsocketTest/hello");
//        ws = new WebSocket("ws://www.luocaca.cn/hello-ssm/hello/" + userName);
//        ws = new WebSocket("ws://192.168.1.133:81/hello-ssm/hello/" + userName);

        var isTest = '<%=res.getString("config.istest")%>';


        alert(isTest);

        if (isTest == true) {
            ws = new WebSocket("ws://localhost:81/hello-ssm/hello/" + userName);
        } else {
            ws = new WebSocket("ws://www.luocaca.cn/hello-ssm/hello/" + userName);
        }

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

<br/>
看直播网站11111111：<a href="video.jsp" target="_blank">点我点我</a>
<br/>


<br/>
上传文件网站：<a href="up.jsp" target="_blank">点我点我</a>
<br/>

<br/>
网站：<a href="hisen.me" target="_blank">hisen.me</a>
<br/><br/><br/><br/>


<%--192.168.1.127:81--%>
<br/><br/>
<%--<a href="http://www.luocaca.cn/hello-ssm/book/push/83e5cb7bdda14d49b5ca16b1197c8134" target="_blank">推送</a>--%>
<%--<a href="http://localhost:81/book/hello-ssm/push/955a53481d514a3eb424c7e74463f03a" target="_blank">推送</a>--%>
<a href="http://192.168.1.136:81/hello-ssm/book/push/83e5cb7bdda14d49b5ca16b1197c8134" target="_blank">推送</a>
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


<%--<div>--%>

    <%--<video src="http://www.luocaca.cn/hello-ssm/upload/wx_camera_1510393866974.mp4"--%>
           <%--style="width: 300px ;--%>
            <%--height: 300px ;"--%>
           <%--autoplay="true" controls="controls">--%>

    <%--</video>--%>


<%--</div>--%>


<%--<video id="roomVideo" class="video-js vjs-default-skin vjs-big-play-centered"--%>
       <%--style="width: 300px ;--%>
            <%--height: 300px ;"--%>
       <%--x-webkit-airplay="allow"--%>
       <%--poster="" webkit-playsinline playsinline x5-video-player-type="h5"--%>
       <%--x5-video-player-fullscreen="true" preload="auto" controls="controls"--%>
<%--&lt;%&ndash;src="https://ws.streamhls.huya.com/hqlive/77259038-2622305922-11262718175097126912-3407890260-10057-A-1514250789-1_1200/playlist.m3u8"&ndash;%&gt;--%>
       <%--src="http://www.luocaca.cn/hello-ssm/upload/景甜.webp"--%>

       <%--autoplay="true">--%>
    <%--<source--%>
    <%--&lt;%&ndash;src="https://ws.streamhls.huya.com/hqlive/77259038-2622305922-11262718175097126912-3407890260-10057-A-1514250789-1_1200/playlist.m3u8"&ndash;%&gt;--%>
            <%--src="http://www.luocaca.cn/hello-ssm/upload/景甜.webp"--%>
            <%--type="application/x-mpegURL">--%>
<%--</video>--%>

<script src="./video.js?v=fc5104a2ab23"></script>
<script src="./videojs-contrib-hls.js?v=c726b94b9923"></script>

<script type="text/javascript">
    var myPlayer = videojs('roomVideo', {
        bigPlayButton: false,
        textTrackDisplay: false,
        posterImage: true,
        errorDisplay: false,
        controlBar: false
    }, function () {
        console.log(this)
        this.on('loadedmetadata', function () {
            console.log('loadedmetadata');
            //加载到元数据后开始播放视频
            startVideo();
        })

        this.on('ended', function () {
            console.log('ended')
        })
        this.on('firstplay', function () {
            console.log('firstplay')
        })
        this.on('loadstart', function () {
            //开始加载
            console.log('loadstart')
        })
        this.on('loadeddata', function () {
            console.log('loadeddata')
        })
        this.on('seeking', function () {
            //正在去拿视频流的路上
            console.log('seeking')
        })
        this.on('seeked', function () {
            //已经拿到视频流,可以播放
            console.log('seeked')
        })
        this.on('waiting', function () {
            console.log('waiting')
        })
        this.on('pause', function () {
            console.log('pause')
        })
        this.on('play', function () {
            console.log('play')
        })

    });

    var isVideoBreak;

    function startVideo() {

        myPlayer.play();

        //微信内全屏支持
        document.getElementById('roomVideo').style.width = window.screen.width + "px";
        document.getElementById('roomVideo').style.height = window.screen.height + "px";


        //判断开始播放视频，移除高斯模糊等待层
        var isVideoPlaying = setInterval(function () {
            var currentTime = myPlayer.currentTime();
            if (currentTime > 0) {
                $('.vjs-poster').remove();
                clearInterval(isVideoPlaying);
            }
        }, 200)

        //判断视频是否卡住，卡主3s重新load视频
        var lastTime = -1,
            tryTimes = 0;

        clearInterval(isVideoBreak);
        isVideoBreak = setInterval(function () {
            var currentTime = myPlayer.currentTime();
            console.log('currentTime' + currentTime + 'lastTime' + lastTime);

            if (currentTime == lastTime) {
                //此时视频已卡主3s
                //设置当前播放时间为超时时间，此时videojs会在play()后把currentTime设置为0
                myPlayer.currentTime(currentTime + 10000);
                myPlayer.play();

                //尝试5次播放后，如仍未播放成功提示刷新
                if (++tryTimes > 5) {
                    alert('您的网速有点慢，刷新下试试');
                    tryTimes = 0;
                }
            } else {
                lastTime = currentTime;
                tryTimes = 0;
            }
        }, 3000)

    }
</script>


</body>
</html>


评论11 （通知）
点赞 取消点赞 删除评论 （message）


messageType = moments;//消息通知类型
momentsId = 83e5cb7bdda14d49b5ca16b1197c8134;//
option = add;//点赞 取消点赞 评论 删除评论 add del
sourceId = 459c3b5a1c4b4ebfba88fe9272c73243; //目标源id 评论id or 点赞id
type = reply; // 评论 reply 点赞thumbUp










