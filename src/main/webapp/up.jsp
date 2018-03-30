<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>


<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>文件上传界面</title>

</head>


<body>


<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/book/image" method="post">

    <input type="file" name="file" id="file" value="文件上传"/>

    <input type="submit" name="submit" id="submit" value="立即上传">

</form>


<br/>
<br/>
<br/>
<br/>
<!-- 定义表单结构 -->
<div id="normal_form" class="form"><!-- 多文件上传 -->
    <h2 class="intro">C. 多文件上传表单</h2>
    <form class="hidden" action="form/uploadMore.do" method="post" enctype="multipart/form-data">
        <p>
            <label>选择要上传的文件:</label>
            <input type="file" name="multipartFiles" />
        </p>

        <p>
            <input type="button" id="addFileItem" value="Add File Item" />
            &nbsp;
            &nbsp;
            &nbsp;
            <input type="submit" value="Submit" />
        </p>
    </form>
</div><!-- /多文件上传 -->












</body>


</html>
