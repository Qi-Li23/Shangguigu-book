<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>

    <%--静态包含base标签、css样式、jQuery文件--%>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            //给删除的a标签绑定单击事件，用于删除的确认提示操作
            $("a.deleteClass").click(function () {
                //confirm是确认框函数，参数是其提示内容，两个按钮，一个确认，一个取消
                return confirm("您确认要删除【"+ $(this).parent().parent().find("td:first").text() +"】吗？");
            })
        })
    </script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="/static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>

        <%-- 静态包含后台管理菜单页面 --%>
        <%@include file="/pages/common/manager_menu.jsp"%>

    </div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
            <c:forEach items="${requestScope.page.items}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.author}</td>
                <td>${item.sales}</td>
                <td>${item.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${item.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${item.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>
            </c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>	
		</table>
        <%--静态包含分页条--%>
        <%@include file="/pages/common/page_nav.jsp"%>


    <%-- 静态包含页脚内容 --%>
    <%@ include file="/pages/common/footer.jsp"%>

</body>
</html>