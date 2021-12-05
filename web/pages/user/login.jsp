<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>尚硅谷会员登录页面</title>

    <%--静态包含base标签、css样式、jQuery文件--%>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            //给登录按钮绑定单击事件
            $("#sub_btn").click(function () {
                //对表单进行验证
                // 验证用户名：必须由字母，数字下划线组成，并且长度为5 到12 位
                //1.获取输入框的值
                var username = $("#username").val();
                //2.创建正则表达式对象
                var usernamepatt = /^\w{5,12}$/;
                //3.使用正则表达式的test方法
                if(!usernamepatt.test(username)) {
                    //用户名不合法
                    $("span.errorMsg").text("用户名不合法！");
                    return false;
                }
                // 验证密码：必须由字母，数字下划线组成，并且长度为5 到12 位
                //1.获取输入框的值
                var password = $("#password").val();
                //2.创建正则表达式对象
                var passwordpatt = /^\w{5,12}$/;
                //3.使用正则表达式对象的test方法
                if(!passwordpatt.test(password)) {
                    //密码不合法
                    $("span.errorMsg").text("密码不合法！");
                    return false;
                }
            })
        })
    </script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">
                                    <%--<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>--%>
                                    ${ empty requestScope.msg ? "请输入用户名和密码" : requestScope.msg}
                                </span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
                                    <input type="hidden" name="action" value="login"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
                                           autocomplete="off" tabindex="1" name="username"
                                           value="${ requestScope.username }"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
                                           autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>

        <%-- 静态包含页脚内容 --%>
        <%@ include file="/pages/common/footer.jsp"%>

</body>
</html>