<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<td width="495" align="center"><br/>
    <form action="${pageContext.request.contextPath}/listByCondition" method="post" name="mf">
        <input type="hidden" name="page" value="1"/>
        <script>
            function fswitch(id) {
                var o = document.getElementById(id);
                if (o) {
                    if (o.style.display == "none") {
                        $(o).fadeIn(3000);
                    } else {
                        $(o).fadeOut(3000);
                    }
                }
            }
        </script>
        <div style="text-align:left;width:88%;">
            <input name="title">
            <input type="submit" value="查询" class="btn"> <span onclick="fswitch('advSearch');"
                                                               style="cursor:hand;color:blue;">高级搜索</span>
        </div>

        <table width="88%;" id="advSearch" style="border:solid 0px #000;display:none;">

            <tr>
                <td>区县：</td>
                <td><select name="qxid" onChange="selectjd()" style="width:80px">
                    <option value='0'>不限--</option>
                    <c:forEach items="${requestScope.qxList}" var="i" varStatus="j">
                        <option value="${i.qxid}">${i.qx}</option>
                    </c:forEach>
                </select></td>
                <td rowspan="6">&nbsp;</td>
            </tr>
            <tr>
                <td>街道：</td>
                <td><select name="jdid" style="width:80px">
                    <option value="0">不限--</option>
                    <c:forEach items="${requestScope.jdList}" var="i" varStatus="j">
                        <option value="${i.jdid}">${i.jd}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td>租金：</td>
                <td><input type="text" name="zj1" size="5" class="unnamed1"> 至 <input type="text" name="zj2"
                                                                                      size="5" class="unnamed1">
                    元/月
                </td>
            </tr>
            <tr>
                <td>户型：</td>
                <td><select name="shi" style="width:60px">
                    <option value="0">不限--</option>
                    <c:if test="${requestScope.shi>=1}">
                        <c:forEach begin="1" end="${requestScope.shi}" step="1" var="i">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </c:if>
                </select>室 <select name="ting" style="width:60px">
                    <option value="0">不限--</option>
                    <c:if test="${requestScope.ting>=1}">
                        <c:forEach begin="1" end="${requestScope.ting}" step="1" var="i">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </c:if>
                </select> 厅
                </td>
            </tr>
            <tr>
                <td>房屋类型：</td>
                <td>
                    <c:forEach items="${requestScope.fwlxList}" var="i">
                        <input type="checkbox" name="fwlx" value="${i.lxid}">${i.fwlx}
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>发布日期：</td>
                <td><select name="date" style="width:80px">
                    <option value="0">不限--</option>
                    <option value="1">当天</option>
                    <option value="2">近两天</option>
                    <option value="3">近三天</option>
                    <option value="7">近一周</option>
                    <option value="14">近两周</option>
                    <option value="30">近一月</option>
                </select></td>
            </tr>
            <tr>
                <td colspan='3'>
                    <hr/>
                </td>
            </tr>

        </table>
        <table width="88%" cellspacing="0">
            <tr>
                <TD width='250' class="table_title">标题</TD>
                <TD width='90' align='center' class="table_title">月租金</TD>
                <TD align='center' class="table_title">发布日期</TD>
            </tr>

            <c:forEach items="${requestScope.fwxxList}" var="i">
                <tr>
                    <td><a href='${pageContext.request.contextPath}/detail?fwid=${i.fwid}'>${i.title}</a></td>
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
        <select name="fenye" onchange="selectChange(this.value)">
            <c:forEach begin="1" end="${pageCount}" step="1" var="i">
                <option value="${i}">第${i}页</option>
            </c:forEach>
        </select>
    </form>
</td>
