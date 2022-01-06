<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>

    <%--静态包含base标签、css样式、jQuery文件--%>
    <%@include file="/pages/common/head.jsp"%>

    <script type="text/javascript">
        $(function() {
            //给用户名绑定失去焦点事件
			$("#username").blur(function () {
                var username = $("#username").val();
                $.getJSON("userServlet?action=existsUsername&username=" + username, function (data) {
                    if(data.existsUsername) {
                        $("span.errorMsg").text("用户名已存在！");
                    } else {
                        $("span.errorMsg").text("用户名可用！");
                    }
                })
            })


            //给验证码图片绑定单击事件
            $("#code_jpg").click(function () {
                // 在事件响应的function 函数中有一个this 对象。这个this 对象，是当前正在响应事件的dom 对象
                // src 属性表示验证码img 标签的图片路径。它可读，可写
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            })

            //给注册按钮绑定单击事件
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
                // 验证确认密码：和密码相同
                //1.获取确认密码
                var repwd = $("#repwd").val();
                //2.和密码比较，看是否一致
                if(repwd != password) {
                    //不一致，则提示用户
                    $("span.errorMsg").text("确认密码和密码不一致！");
                    return false;
                }
                // 邮箱验证：xxxxx@xxx.com
                //1.获得邮箱内容
                var email = $("#email").val();
                //2.创建正则表达式对象
                var emailpatt = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                //3.使用test方法验证
                if(!emailpatt.test(email)) {
                    //4.提示用户
                    $("span.errorMsg").text("邮箱格式不合法！");
                    return false;
                }
                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                var codeText = $("#code").val();
                //去掉验证码前后的空格
                codeText = $.trim(codeText);
                if(codeText == null || codeText == "") {
                    //验证码不合法！
                    $("span.errorMsg").text("验证码不能为空！");
                    return false;
                }
                $("span.errorMsg").text("");
            })
        })
    </script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
                                    ${ requestScope.msg }
                                </span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
                                    <input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
                                           value="${ requestScope.username }"
                                           autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
                                           autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
                                           autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
                                           value="${ requestScope.email }"
                                           autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 100px;" name="code" id="code"/>
									<img id="code_jpg" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 100px; height: 28px;">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
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