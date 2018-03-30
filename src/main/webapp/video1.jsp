<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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



        .video-js {
            margin: 0 auto;
        }

        input {
            margin-top: 15px;
            /*min-width: 450px;*/
            width: 100%;
            padding: 5px;
        }
    </style>

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>

<body>



<div class="container">

    <section class="starter-template">

        <form id=load-url>
            <label>
                Video URL:
                <input id=url type=url style="width: 100%"
                       value="http://www.luocaca.cn/hello-ssm/upload/playlist.m3u8">
            </label>
            <button type=submit>Load</button>
        </form>
        <!--
          -- Your Video element. Just like regular HTML5 Video.
          -->
        <video id=example-video width=315 height=180px class="video-js vjs-default-skin" controls="controls"
               autoplay="true">
            <source
            <%--src="https://ws.streamhls.huya.com/hqlive/77259038-2622305922-11262718175097126912-3407890260-10057-A-1514250789-1_1200/playlist.m3u8"--%>
                    src="http://www.luocaca.cn/hello-ssm/upload/playlist.m3u8"
                    type="application/x-mpegURL">
        </video>



    </section>


</div>


</div><!-- /.container -->



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


</script>








</html>


<%--https://videojs.github.io/videojs-contrib-hls/--%>
