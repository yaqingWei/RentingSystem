<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<HTML>
<HEAD>
    <TITLE>北京出租房</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">

    <link href="style/mycss.css" rel="stylesheet" type="text/css"/>
    <link href="style/texts.css" rel="stylesheet" type="text/css"/>
    <link href="style/btn.css" rel="stylesheet" type="text/css"/>

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

                        ${requestScope.user==null?'游客':requestScope.user.uname}</font>
                    </td>
                </tr>
                <c:choose>
                    <c:when test="${requestScope.user==null}">
                        <tr>
                            <td width='100'><a href="my.jsp">返回首页</a></td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td width='150'><a href="my.jsp">管理我的租房信息</a></td>
                        </tr>
                        <tr>
                            <td width='100'><a href="post.jsp">发布租房信息</a></td>
                        </tr>
                        <tr>
                            <td width='100'><a href="my.jsp">返回首页</a></td>
                        </tr>
                        <tr>
                            <td width='100'><a href="${pageContext.request.contextPath}/logout">[注销]</a></td>
                        </tr>
                    </c:otherwise>
                </c:choose>


            </table>
        </td>
        <td width="35" background="images/layout_24.gif">&nbsp;</td>
        <td width="495">
            <table>
                <tr>
                    <td width="3%">&nbsp;</td>
                    <td width="97%">


                        <table>
                            <tr>
                                <TD width='250'>标题</TD>
                                <TD width='90' align='center'>月租金</TD>
                                <TD align='center'>发布日期</TD>
                            </tr>
                            <tr>
                                <td colspan='3'>
                                    <hr/>
                                </td>
                            </tr>

                            <c:forEach items="${requestScope.fwxxList}" var="i">
                                <tr>
                                    <td>
                                        <a href='${pageContext.request.contextPath}/detail?fwid=${i.fwid}'>${i.title}</a>
                                    </td>
                                    <td align='center' style='height:30px;'>${i.zj}元</td>
                                    <td align='center'><fmt:formatDate value="${i.date}" pattern="yyyy-MM-dd"/></td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan='3'>
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