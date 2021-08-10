<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<HTML>
<HEAD>
    <TITLE>北京出租房</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">

    <link href="style/mycss.css" rel="stylesheet" type="text/css"/>
    <link href="style/text.css" rel="stylesheet" type="text/css"/>
    <link href="style/btn.css" rel="stylesheet" type="text/css"/>
    <script src="jquery/jquery.js"></script>
    <script type="text/javascript">
            function loginDel(fwid){
                if(confirm("您确定要删除吗?")){
                 $.ajax({
                     data:{fwid:fwid},
                     dataType:"text",
                     url:"${pageContext.request.contextPath}/logicDel",
                     success:function(result){
                         alert(result);
                         location.href="${pageContext.request.contextPath}/loginGo?uid=${user.uid}&page=1";
                     }
                 });
            }
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
        <td width="172" valign="top">

            <script language="javascript">
                <!--
                function login() {
                    if (document.myForm.uname.value == "") {
                        alert("用户名不能为空");
                        return false;
                    } else if (document.myForm.upass.value == "") {
                        alert("密码不能为空");
                        return false;
                    } else {
                        return true;
                    }
                }

                -->
            </script>

            <table align="center">
                <tr>
                    <td width=''><font color='red'>当前用户：

                        ${user.uname}</font>
                    </td>
                </tr>
                <tr>
                    <td width='150'><a href="my.jsp">管理我的租房信息</a></td>
                </tr>
                <tr>
                    <td width='100'><a href="post.jsp">发布租房信息</a></td>
                </tr>
                <tr>
                    <td width='100'><a href="${pageContext.request.contextPath}/loginGo?uid=${user.uid}&page=1">返回首页</a>
                    </td>
                </tr>
                <tr>
                    <td width='100'><a href="${pageContext.request.contextPath}/logout">[注销]</a></td>
                </tr>
            </table>
        </td>
        <td width="35" background="images/layout_24.gif">&nbsp;</td>
        <td width="495">
            <table>
                <tr>
                    <td width="3%">&nbsp;</td>
                    <td width="97%">


                        <table width='450' border='0'>
                            <tr>
                                <TD>标题</TD>
                                <TD width='100' align='center'>月租金</TD>
                                <TD width='110' align='center'>发布日期</TD>
                                <TD width='50'>&nbsp;</TD>
                                <TD width='50'>&nbsp;</TD>
                            </tr>
                            <tr>
                                <td colspan='5'>
                                    <hr/>
                                </td>
                            </tr>
                            <c:forEach items="${sessionScope.fwxxList}" var="i">
                                <tr>
                                    <td>
                                        <a href='${pageContext.request.contextPath}/detail?fwid=${i.fwid}'>${i.title}</a>
                                    </td>
                                    <td align='center' style='height:30px;'>${i.zj}元</td>
                                    <td align='center' style='height:30px;'><fmt:formatDate value="${i.date}"
                                                                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                    <td align='center' style='height:30px;'><a href='javascript:void(0)' onclick="loginDel(${i.fwid})">[删除]</a></td>
                                    <td align='center' style='height:30px;'><a href='${pageContext.request.contextPath}/updateFwxx?fwid=${i.fwid}'>[修改]</a></td>
                                </tr>
                            </c:forEach>

                            <tr>
                                <td colspan='5'>
                                    <hr/>
                                </td>
                            </tr>
                        </table>


                    </td>
                </tr>
                <tr>
                    <td colspan="2"></td>
                </tr>
            </table>
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