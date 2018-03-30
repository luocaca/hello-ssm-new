<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<% String appPath = request.getContextPath();
//    ResourceBundle res = ResourceBundle.getBundle("config.properties");
    ResourceBundle res = ResourceBundle.getBundle("config");
//    ResourceBundle res = ResourceBundle.getBundle("config.istest");
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>VideoJS HLS</title>

    <!-- Bootstrap core CSS. This is just to make the demo look
    nice. It's not required for videojs-contrib-hls to work. -->
    <link href="node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Some custom styles for the demo page -->
    <style>
        body {
            padding-top: 50px;
            color: #868688;
            background-color: #FAFCFF;
        }

        nav {
            background-color: #e7e7e7
        }

        nav a {
            color: #868688;
        }

        nav a:hover {
            color: #606062;
            text-decoration: none;
        }

        .navbar-toggle .icon-bar {
            background-color: #868688;
        }

        .starter-template {
            padding: 40px 15px;
            text-align: center;
        }

        .video-js {
            margin: 0 auto;
        }

        input {
            margin-top: 15px;
            min-width: 450px;
            padding: 5px;
        }
    </style>

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


    <script type="text/javascript">
        var ws;
        //        ws = new WebSocket("ws://localhost:81/hello-ssm/hello/" + );
        //        hello("游客")

        // 默认以游客登录
        function hello(str) {

            var userName = document.getElementById("name").value;
//        ws = new WebSocket("ws://127.0.0.1:81/WebsocketTest/hello");
//        ws = new WebSocket("ws://www.luocaca.cn/hello-ssm/hello/" + userName);
//        ws = new WebSocket("ws://192.168.1.134:81/hello-ssm/hello/" + userName);


            var isTest = '<%=res.getString("config.istest")%>';

            alert(isTest);


            if (isTest == true) {
                if (str == "游客") {
                    ws = new WebSocket("ws://localhost:81/hello-ssm/hello/" + "游客");
                } else {
                    close();
                    ws = new WebSocket("ws://localhost:81/hello-ssm/hello/" + userName);
                }
            } else {
                if (str == "游客") {
                    ws = new WebSocket("ws://www.luocaca.cn/hello-ssm/hello/" + "游客");
                } else {
                    close();
                    ws = new WebSocket("ws://www.luocaca.cn/hello-ssm/hello/" + userName);
                }
//                ws = new WebSocket("ws://www.luocaca.cn/hello-ssm/hello/" + userName);
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
                content.scrollTop = content.scrollHeight;

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


</head>

<body>

<nav class="navbar navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"--%>
            <%--aria-expanded="false" aria-controls="navbar">--%>

            <%--<span class="icon-bar"></span>--%>
            <%--<span class="icon-bar"></span>--%>
            <%--</button>--%>
            <%--<span class="sr-only">欢迎来到大傻的世界----复制直播地址到 栏目 进行播放。地址找大傻要。。。。定时下发更新</span>--%>
            <span class="icon-bar">填写用户名 进行登录聊天系统<input type="text" id="name"> <input type="button" value="login"
                                                                                      onclick="{

                hello();
                                                                                      }"></span>
            <a class="navbar-brand" href="#">**大傻么么哒**</a>
        </div>

    </div>
</nav>


<div class="container">


    <section class="starter-template">


        <!--
          -- Your Video element. Just like regular HTML5 Video.
          -->
        <video id=example-video width=600 height=400 class="video-js vjs-default-skin" controls="controls"
               autoplay="true">
            <source
            <%--src="https://ws.streamhls.huya.com/hqlive/77259038-2622305922-11262718175097126912-3407890260-10057-A-1514250789-1_1200/playlist.m3u8"--%>
                    src="http://www.luocaca.cn/hello-ssm/upload/playlist.m3u8"
                    type="application/x-mpegURL">
        </video>

        <form id=load-url>
            <label>
                Video URL:
                <input id=url type=url
                       value="http://www.luocaca.cn/hello-ssm/upload/playlist.m3u8">
            </label>
            <button type=submit>Load</button>
        </form>

    </section>


</div>


</div><!-- /.container -->


<div style="width:300px; height: 400px;  ; position: fixed ; top: 120px ; left: 0px; ">



    <textarea name="aa" id="content" cols="30" rows="10" style="width: 200px ; height: 400px;">

    </textarea>


    <%-- onkeypress="EnterPress(event)" onkeydown="EnterPress()" --%>
    <textarea id="msg" name="msg" onkeydown="keyLogin(event)"></textarea>
    <input type="button" value="发送" onclick="subsend()">


</div>

</body>


<!-- Bootstrap stuff. These three scripts aren't necessary for you
     to use videojs-contrib-hls -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="js/ie10-viewport-bug-workaround.js"></script>


<!--------------------------------------------------------------------------
  --                      videojs-contrib-hls setup                       --
  ------------------------------------------------------------------------!>

<!--
  -- Make sure to include the Video.js CSS. This could go in
  -- the <head>, too.
  -->
<link href="https://unpkg.com/video.js/dist/video-js.css" rel="stylesheet">

<!--
  -- Include Video.js and videojs-contrib-hls in your page
  -->

<script src="https://unpkg.com/video.js/dist/video.js"></script>
<script src="https://unpkg.com/videojs-flash/dist/videojs-flash.js"></script>
<script src="https://unpkg.com/videojs-contrib-hls/dist/videojs-contrib-hls.js"></script>

<!--
  -- Now, initialize your player. That's it!
  -->
<script type="text/javascript">
    (function (window, videojs) {
        var player = window.player = videojs('example-video');

        // hook up the Video switcher
        var loadUrl = document.getElementById('load-url');
        var url = document.getElementById('url');
        loadUrl.addEventListener('submit', function (event) {
            event.preventDefault();
            player.src({
                //  src:  http://video2.baliup.com:88/m3u8//"+8/8.m3u8 ,
//                src: "http://video2.baliup.com:88/m3u8/" + "/" + (url.value) + "/" + (url.value) + ".m3u8",
                src: url.value,
                type: 'application/x-mpegURL'
            });
            url.value = url.value;
            return false;
        });
    }(window, window.videojs));


    $(function () {
        $('#msg').bind('keypress', function (event) {
            if (event.keyCode == "13") {
                subsend();
            }
        });
    });

</script>


<script language="JavaScript">


    function keyLogin(e) { //传入 event
        var e = e || window.event;

        if (e.keyCode == 13) {
            subsend();
        }
    }

    //    function keyLogin(){
    //        if (event.keyCode==13)  //回车键的键值为13
    //            subsend();
    //    }
</script>


<%--<script defer="defer" language="javascript">--%>

<%--hello("游客")--%>

<%--< /body>--%>
<%----%>
<%----%>
<%----%>

<%--</script>--%>


<script language="javascript" for="window" event="onload">
    hello("游客");
</script>


</html>


<%--https://videojs.github.io/videojs-contrib-hls/--%>
