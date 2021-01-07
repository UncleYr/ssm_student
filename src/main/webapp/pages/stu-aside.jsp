<%--
  Created by IntelliJ IDEA.
  User: 15181
  Date: 2020/12/30
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="main-sidebar">
    <section class="sidebar">
        <div class="user-panel">
            <div class="pull-left info">
                <p>
                    <security:authentication property="principal.username"/>
                </p>
            </div>
        </div>
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
                <span>个人信息管理</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>


            </a>
                <ul class="treeview-menu">

                    <li>
                        <a href="${pageContext.request.contextPath}/pages/stu-info.jsp">
                            <i class="fa fa-circle-o"></i> 个人信息</a>
                    </li>
                    <li><a
                            href="${pageContext.request.contextPath}/user/findCourse"> <i
                            class="fa fa-circle-o"></i> 查看已选课程
                    </a></li>
                    <%-- <li><a
                             href="${pageContext.request.contextPath}/pages/syslog-list.jsp"> <i
                             class="fa fa-circle-o"></i> 访问日志
                     </a></li>--%>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"> <i class="fa fa-cube"></i>
                    <span>选课</span> <span class="pull-right-container"> <i
                            class="fa fa-angle-left pull-right"></i>
				</span>
                </a>
                <ul class="treeview-menu">

                    <li><a
                            href="${pageContext.request.contextPath}/user/showCourse">
                        <i class="fa fa-circle-o"></i> 公选课
                    </a></li>
                    <li><a
                            href="${pageContext.request.contextPath}/user/showCourse">
                        <i class="fa fa-circle-o"></i> 必修课
                    </a></li>
                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
