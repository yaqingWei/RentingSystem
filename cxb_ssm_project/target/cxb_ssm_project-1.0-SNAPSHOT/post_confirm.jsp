
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/fmt" %>
<HTML>
<HEAD>
<TITLE>北京出租房</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<link href="style/mycss.css" rel="stylesheet" type="text/css" />
<link href="style/texts.css" rel="stylesheet" type="text/css" />
<link href="style/btn.css" rel="stylesheet" type="text/css" />
<script   language="javascript">   
function back()   
{   
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
	function login(){
		if( document.myForm.uname.value =="" ){
			alert("用户名不能为空");
			return false;
		}else if(document.myForm.upass.value == ""){
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

			stan</font>
		</td>
	</tr>
	<tr>
		<td width='150'><a href="my.jsp">管理我的租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="post.jsp">发布租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="${pageContext.request.contextPath}/loginGo?uid=${user.uid}&page=1">返回首页</a></td>
	</tr>
	<tr>
		<td width='100'><a href="${pageContext.request.contextPath}/logout">[注销]</a></td>
	</tr>
	</table>
</td>
    <td width="35" background="images/layout_24.gif">&nbsp;</td>
    <td width="495">
	<table width="460">
	  <tr>
		<td>请确认您要发布的信息：</td>
		<td>&nbsp;</td>
	  </tr>
	  <tr>
		<td colspan="2"><hr/></td>
	  </tr>				  
	  <tr>
		<td>${fwxx.title}<br/></td>
	  </tr>
	  <tr>
		<td><strong>电话/手机：</strong>${fwxx.telephone}</td>
	  </tr>
	  <tr>
		<td><strong>联系人：</strong>${fwxx.lxr}</td>
	  </tr>
	  <tr>
		<td><strong>房屋类型：</strong>${fwlx.fwlx}</td>
	  </tr>
	  <tr>
		<td><strong>户型：</strong>${fwxx.shi}室${fwxx.ting}厅</td>
	  </tr>
	  <tr>
		<td><strong>价格：</strong>${fwxx.zj}元</td>
	  </tr>
	  <tr>
		<td><strong>地段：</strong>${qx.qx}&nbsp;&nbsp;${jd.jd}</td>
	  </tr>
	  <tr>
		<td><strong>发布时间<c:formatDate value="${fwxx.date}" pattern="yyyy-MM-dd HH:mm:ss"/></strong></td>
	  </tr>
	  <tr>
		<td><hr></td>
	  </tr>
	  <tr>
		<td>${fwxx.fwxx}</td>
	  </tr>
	  <tr>
		<td><hr></td>
	  </tr>
	  <tr>
		<td>
		<form action="my.htm" method="POST">
			<input type="hidden" name="affirm" value="y"/>
			<input type="hidden" name="title" value="${fwxx.title}"/>
			<input type="button" value="确认提交" class="btn" onclick="location.href='${pageContext.request.contextPath}/loginGo?uid=${user.uid}&page=1'">&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="返回修改" class="btn" onclick="back()">
		</form>
		</td>
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