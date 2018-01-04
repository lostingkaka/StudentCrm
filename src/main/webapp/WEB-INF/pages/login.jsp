<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>

<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"
      background="${pageContext.request.contextPath}/images/rightbg.jpg">
<div ALIGN="center">
    <table border="0" width="1140px" cellspacing="0"
           cellpadding="0" id="table1">
        <tr>
            <td height="93"></td>
            <td></td>
        </tr>
        <tr>
            <td background="${pageContext.request.contextPath}/images/rights.jpg"
                width="740" height="412">
            </td>
            <td class="login_msg" width="400" align="center">
                <!-- margin:0px auto; 控制当前标签居中 -->
                <fieldset style="width:auto; margin:0px auto;">
                    <legend>登录</legend>
                    <%-- 提交后的位置：/WEB-INF/pages/frame.jsp--%>
                    <s:fielderror cssStyle="color:red"></s:fielderror>
                    <s:form namespace="/user" action="userAction_login" method="post">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <img src="${pageContext.request.contextPath}/images/title.png"
                             width="185" height="26" align="center"/>
                        <br/><br/>
                        用户名：<s:textfield cssClass="msg" name="logonName"/>
                        <br/><br/>
                        密&nbsp;&nbsp;码：<s:password cssClass="msg" name="logonPwd"/>
                        <br/><br/>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <s:submit cssClass="btn" value="登录"/>
                        <s:reset cssClass="btn" value="重置"/>
                    </s:form>
                </fieldset>
            </td>
        </tr>
    </table>
</div>
</BODY>
</HTML>
