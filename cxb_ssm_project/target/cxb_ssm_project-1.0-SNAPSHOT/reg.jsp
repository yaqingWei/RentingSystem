<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD>
    <TITLE>北京出租房</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">

    <link href="style/mycss.css" rel="stylesheet" type="text/css"/>
    <link href="style/text.css" rel="stylesheet" type="text/css"/>
    <link href="style/btn.css" rel="stylesheet" type="text/css"/>
    <script src="jquery/jquery.js"></script>
    <script lang="javascript">
        function existsUname(){
                $.ajax({
                    url:"${pageContext.request.contextPath}/existsUname",
                    data:{uname:$("[name='uname']").val()},
                    method:"post",
                    success:function(data){
                        if(data==0){
                            $("[name='uname']").siblings("span").html("<font color='green'>✔</font>");
                            return true;
                        }else{
                            $("[name='uname']").siblings("span").html("<font color='red'>用户名已存在</font>");
                            return false;
                        }
                    }
                });
        }
        $(function(){
          $("[name='uname']").bind("blur",existsUname) ;
        });
        function pass() {
            var pass = false;
            if (document.myForm.uname.value == "") {
                alert("用户名不能为空");
                pass = false;
            } else if (document.myForm.upass.value == "") {
                alert("密码不能为空");
                pass = false;
            } else if (document.myForm.upass.value != document.myForm.upass1.value) {
                alert("两次密码不一样");
                pass = false;
            } else if ($("input[name='code']:first").val() == "") {
                alert("请填写验证码");
                pass = false;
            } else if ($("input[name='code']:first").val() !='${sessionScope.code}') {
                alert("验证码错误");
                pass = false;
            }else {
                pass = true;
            }
            return pass;


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
                    <td><a href="${pageContext.request.contextPath}/selectAll?page=1">返回首页</a></td>
                </tr>
                <tr>
                    <td><a href="login_form.jsp">用户登陆</a></td>
                </tr>
            </table>
        </td>
        <td width="35" background="images/layout_24.gif">&nbsp;</td>
        <td width="495">
            <form action="${pageContext.request.contextPath}/register" method="post" name="myForm" onsubmit="return pass()">
                <table align="center">
                    <tr>
                        <td>用户注册：</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr/>
                        </td>
                    </tr>
                    <tr>
                        <td>用户名：</td>
                        <td><input type="text" name="uname"> &nbsp;<span style="width: 20px;">&nbsp;</span></td>
                    <tr>
                        <td>密码：</td>
                        <td><input type="password" name="upass"></td>
                    <tr>
                    <tr>
                        <td>重复密码：</td>
                        <td><input type="password" name="upass1"></td>
                    </tr>
                    <tr>
                        <td>验证码:</td>
                        <td>
                            <img src="${pageContext.request.contextPath}/yanzhengMa">
                            <input name="code" style="width: 80px">
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="注册" class="btn">&nbsp;</td>
                        <td><input type="reset" value="重置" class="btn"></td>
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