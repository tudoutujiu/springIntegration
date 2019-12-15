<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/12 0012
  Time: 上午 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加商品</title>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/public/js/jquery-3.4.1.min.js"></script>
    <script>
        function father(mid) {
            if(mid<0){
                $("#fo").attr('action',"${pageContext.request.contextPath}/book/addBooks");
                $("#fo").submit();
            }else{
                $("#fo").attr('action',"${pageContext.request.contextPath}/book/updatabyid/"+mid);
                $("#fo").submit();
            }
        }
    </script>
</head>
<body>
    <form id="fo" action="" method="post" enctype="multipart/form-data">
        <input type="hidden" name="bookimg" value="${onlybook.bookimg}"/>
        <label>输入书名：</label><input type="text" name="bname" id="bname" value="${onlybook.bname}"/><br/>
        <label>输入价格：</label><input type="number" name="price" id="price" value="${onlybook.price}"/><br/>
        <label>输入作者：</label><input type="text" name="author" id="author" value="${onlybook.author}"/><br/>
        <label>输入存量：</label><input type="number" name="stock" id="stock" value="${onlybook.stock}"/><br/>
        <label>输入简介：<br/></label><textarea style="margin-left:80px; " cols="22" rows="5" name="details" id="details">
            ${onlybook.details}
        </textarea><br/>
        <label>放入封面：</label><input type="file" name="myimg" id="myimg"/><br/>
        <p><img src="${pageContext.request.contextPath}${onlybook.bookimg}" style="width: 120px;"/>
        </p>
        <input type="button" name="sub" id="sub" value="提交数据" onclick="javascript:father(${onlybook.id})"/>
    </form>
</body>
</html>
