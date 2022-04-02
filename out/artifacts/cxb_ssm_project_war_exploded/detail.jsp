<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<HTML>
<HEAD>
    <TITLE>北京出租房</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>
    <link href="style/mycss.css" rel="stylesheet" type="text/css"/>
    <link href="style/text.css" rel="stylesheet" type="text/css"/>
    <link href="style/btn.css" rel="stylesheet" type="text/css"/>
    <link href="style/index5.css" rel="stylesheet" type="text/css"/>
    <script src="jquery/index5.js"></script>
    <script language="javascript">
        function back() {
            window.history.back();
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
                <c:choose>

                    <c:when test="${user!=null}">
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
                            <td width='100'><a
                                    href="${pageContext.request.contextPath}/loginGo?uid=${user.uid}&page=1">返回首页</a>
                            </td>
                        </tr>
                        <tr>
                            <td width='100'><a href="${pageContext.request.contextPath}/logout">[注销]</a></td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td width=''><font color='red'>当前用户：

                                游客</font>
                            </td>
                        </tr>
                        <tr>
                            <td width='100'><a
                                    href="selectAll">返回首页</a></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </table>
        </td>
        <td width="35" background="images/layout_24.gif">&nbsp;</td>
        <td width="495" align="center">

            <table width="450">
                <tr>
                    <td id=listTitle>${requestScope.fwxx.title}</td>
                    <td></td>
                </tr>
                <td><strong>电话/手机：</strong>${requestScope.fwxx.telephone}</td>
                <td rowspan="9">
                    <div id="container" class="row">
                        <div id="smallDiv" class="thumbnail">
                            <img src="images/${requestScope.fwxx.img}" width="200px"/>
                            <div class="text-center">
                                <br>
                                <br>
                                <br>
                                <button class="btn btn-danger"><span class="glyphicon glyphicon-heart"></span>喜欢
                                </button>&nbsp;&nbsp;&nbsp;
                                <button class="btn btn-info"><span class="glyphicon glyphicon-envelope">私信</span>
                                </button>
                            </div>
                            <div id="zoomDiv"></div>
                            <div id="cover"></div>
                        </div>
                        <div id="bigDiv">
                            <img src="images/${requestScope.fwxx.img}" width="200"/>
                        </div>
                    </div>
                </td>
                </tr>
                <tr>
                    <td><strong>联系人：</strong>${requestScope.fwxx.lxr}</td>
                </tr>
                <tr>
                    <td><strong>房屋类型：</strong>${requestScope.fwxx.tbl_fwlx.fwlx}</td>
                </tr>
                <tr>
                    <td><strong>户型：</strong>${requestScope.fwxx.shi}室${requestScope.fwxx.ting}厅</td>
                </tr>
                <tr>
                    <td><strong>价格：</strong>${requestScope.fwxx.zj}元</td>
                </tr>
                <tr>
                    <td><strong>地段：</strong>${requestScope.fwxx.tbl_qx.qx}--区&nbsp;&nbsp;${requestScope.fwxx.tbl_jd.jd}--
                    </td>
                </tr>
                <tr>
                    <td><strong>发布时间：<fmt:formatDate value="${requestScope.fwxx.date}"
                                                     pattern="yyyy-MM-dd HH:mm:ss"/></strong></td>
                </tr>
                <tr>
                    <td>
                        <hr>
                    </td>
                </tr>
                <tr>
                    <td>${requestScope.fwxx.fwxx}</td>
                </tr>
                <tr>
                    <td><input type="button" value="后退" class="btn" onclick="back()"></td>
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