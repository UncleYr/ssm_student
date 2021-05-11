<%--
  Created by IntelliJ IDEA.
  User: 15181
  Date: 2020/12/31
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="main-header">
    <!-- Logo -->
    <a href="${pageContext.request.contextPath}/pages/stu-info.jsp" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>学生</b></span> <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>学生</b>页面</span>
    </a>
    <nav class="navbar navbar-static-top">
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas"
           role="button"> <span class="sr-only">Toggle navigation</span>
        </a>
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu"><a href="#"
                                                       class="dropdown-toggle" data-toggle="dropdown">
                    <%--<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
                        class="user-image" alt="User Image"> <span class="hidden-xs">--%>
                    <security:authentication property="principal.username"/>
                    </span>

                </a>
                    <!-- User image -->
                    <%-- <li class="user-header"><img
                             src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
                             class="img-circle" alt="User Image"></li>--%>

                    <!-- Menu Footer-->
                <li class="user-footer">
                    <div class="pull-left">
                        <a href="#" class="btn btn-default btn-flat"
                           id="updatePswdLink">修改密码</a>
                    </div>
                    <div class="pull-right">
                        <a href="${pageContext.request.contextPath}/user/logout"
                           class="btn btn-default btn-flat"
                        >注销</a>
                    </div>
                </li>
                <%--修改弹出密码框--%>
                <form action="${pageContext.request.contextPath}/user/updatePassword" METHOD="post">
                    <div id="updatePswd" style="display: none;background-color: rgb(241,243,244);
	                    padding: 5px;
                            position: absolute;
                            top: 200px;
                            left: 400px;
                            width: 500px;
                            height: 280px;
                            box-shadow:10px 10px 5px rgba(34,45,50,.5);
                            border-radius: 10px">
                        <div style="position: relative;margin: auto;">
                            <table style="border-collapse:separate; border-spacing:20px; font-family: 'youyuan">
                                <tr>
                                <td >
                                    原密码:
                                </td>
                                <td>
                                   <input type="text" name="oldpswd" style="width: 300px;height: 30px;outline: none;">
                                </td>
                            </tr>
                                <tr>
                                    <td>
                                        新密码:
                                    </td>
                                    <td>
                                        <input type="password" name="newpswd" style="width: 300px;height: 30px;outline: none">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        确认密码:
                                    </td>
                                    <td>
                                     <input type="password" name="newpswd1" style="width: 300px;height: 30px;outline: none">
                                    </td>
                                </tr>
                            </table>
                            <div style="margin-top:20px;position: relative;left:103px;"><input type="submit" style="width: 80px;height: 30px;outline: none" value="确定"></div>
                        </div>
                    </div>
                </form>
                </li>
            </ul>
        </div>
    </nav>
</header>

