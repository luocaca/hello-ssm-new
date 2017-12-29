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


</body>


</html>
