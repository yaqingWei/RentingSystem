<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD>
    <TITLE>北京出租房</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">

    <link href="style/mycss.css" rel="stylesheet" type="text/css"/>
    <link href="style/text.css" rel="stylesheet" type="text/css"/>
    <link href="style/btn.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/jquery/jquery.js"></script>
    <script lang="javascript">
        function login() {
            if (document.myForm.uname.value == "") {
                alert("用户名不能为空");
                return false;
            } else if (document.myForm.upass.value == "") {
                alert("密码不能为空");
                return false;
            } else if ($("input[name='code']:first").val() == "") {
                alert("请填写验证码");
                pass = false;
            } else if ($("input[name='code']:first").val() != '${sessionScope.code}') {
                alert("验证码错误");
                pass = false;
            }
            {
                return true;
            }
        }
      $(function(){
          $("[value='登陆']").click(loginTo);
      });
        function loginTo() {
            var name = document.myForm.uname.value;
            var pass = document.myForm.upass.value;
            if (name == "") {
                alert("用户名不能为空");
                return;
            } else if (pass == "") {
                alert("密码不能为空");
                return;
            }
            var data = JSON.stringify({"uname": name, "upass": pass});
            $.ajax({
                url: "${pageContext.request.contextPath}/login",
                type: "post",
                data: data,
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                success: function (result) {
                    if (result != null) {
                        location.href = "${pageContext.request.contextPath}/loginGo?uid=" + result.uid+"&page=1";
                    } else {
                        alert("登录失败！");
                    }
                }
            });
        }
    </script>
</HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td colspan="5"><img src="images/top.jpg" width="780" height="213"></td>
    </tr>
    <tr>
        <td colspan="5"><img src="images/middle1.jpg" width="780" height="47"></td>
    </tr>
    <tr>
        <td width="38" background="images/middle2.jpg">&nbsp;</td>
        <td width="172">
            <table align="center">
                <tr>
                    <td><a href="selectAll">返回首页</a></td>
                </tr>
                <tr>
                    <td><a href="reg.jsp">用户注册</a></td>
                </tr>
            </table>
        </td>
        <td width="35" background="images/layout_24.gif">&nbsp;</td>
        <td width="495">
            <form action="login.jsp" method="post" name="myForm" onsubmit="return login()">
                <table align="center">
                    <tr>
                        <td colspan="2" align="center">

                        </td>
                    </tr>
                    <tr>
                        <td>用户登陆：</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr/>
                        </td>
                    </tr>
                    <tr>
                        <td>用户名：</td>
                        <td><input type="text" name="uname"></td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td><input type="password" name="upass"></td>
                    </tr>
                    <tr>
                        <td>验证码:</td>
                        <td>
                            <img src="${pageContext.request.contextPath}/yanzhengMa">
                            <input name="code" style="width: 80px">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="hidden" name="sign" value="login"/>
                            <input type="button" value="登陆" class="btn">
                        </td>
                    </tr>
                </table>
            </form>
        </td>
        <td width="40" background="images/middle4.jpg">&nbsp;</td>
    </tr>
    <tr>
        <td colspan="5"><img src="images/bottom.jpg" width="780" height="82"></td>
    </tr>
</table>
<P align="center">华瑞IT教育</P>
<br/>
</BODY>
</HTML>