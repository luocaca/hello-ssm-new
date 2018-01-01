<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.hisen.entity.Book" %>
<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@page import="com.hisen.entity.Book" %>


<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + request.getServerPort();


    Book upBook = new Book();
    upBook.setName("name");
    upBook.setDetail("detail");
    upBook.setBookId(666);
    upBook.setNumber(666);

%>

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>图书添加界面</title>


    <script>


        function sayHellow() {

            <%--alert("nihao" + <%upBook.toString();%>);--%>
//            alert("nihao");
            <%--String msg = ${upBook.bookId};--%>
            <%--alert(msg);--%>
        };


        function addBook() {

        }
    </script>
</head>


<button type="button" content="button" onclick=" sayHellow()">显示属性</button>

<%--<td>--%>
<%--<a href="<%=appPath%>/book/detail/${book.bookId}">详情</a> |--%>
<%--<a href="<%=appPath%>/book/del/${book.bookId}">删除</a>--%>
<%--</td>--%>


<body>

<%--声明变量--%>
<%!


%>


<%--<form method="post" action="${path}/book/add?bookId=666&number=666&detail=abcde&name=xiaoming>--%>
<form method="get" action="${pageContext.request.contextPath}/book/add">
    <%--<form method="get" action="${pageContext.request.contextPath}/book/add/333" >--%>

    <text>
        学生姓名<input type="text" name="name"> <br/>
        学生id<input type="text" name="book_id"> <br/>
        学生编号<input type="text" name="number"> <br/>
        学生描述<input type="text" name="detail"> <br/>
        照片地址<input type="text" name="url"> <br/>
    </text>

    <button onsubmit="addBook()">submit</button>

</form>


<br/>
<br/>
<br/>
<h2>添加视频地址</h2>

<%--<form method="post" action="${path}/book/add?bookId=666&number=666&detail=abcde&name=xiaoming>--%>
<form method="get" action="${pageContext.request.contextPath}/book/addvideo">
    <%--<form method="get" action="${pageContext.request.contextPath}/book/add/333" >--%>

    <text>
        视频名称<input type="text" name="name" value="一个视频"> <br/>
        imageurl<input type="text" name="imageurl"> <br/>
        视频地址<input type="text" name="url"> <br/>
        视频类型<input type="text" name="type"> <br/>
        描述<input type="text" name="comment"> <br/>
    </text>

    <button onsubmit="addBook()">submit</button>

</form>


</body>


</html>
