<%--
  Created by IntelliJ IDEA.
  User: 15181
  Date: 2020/12/30
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
                     class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>
                    <security:authentication property="principal.username" />
                </p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index"><a
                    href="${pageContext.request.contextPath}/pages/adminMain.jsp"><i
                    class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
                <span>教师管理</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>


            </a>
                <ul class="treeview-menu">

                    <li><a
                            href="${pageContext.request.contextPath}/admin/teacher"> <i
                            class="fa fa-circle-o"></i> 查看所有教师信息
                    </a></li>
                    <li><a
                            href="${pageContext.request.contextPath}/admin/course"> <i
                            class="fa fa-circle-o"></i> 查看课程信息
                    </a></li>

                </ul></li>
            <li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
                <span>学生管理</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>
            </a>
                <ul class="treeview-menu">

                    <li><a
                        href="${pageContext.request.contextPath}/admin/student?page=1&size=4">
                    <i class="fa fa-circle-o"></i> 查看学生个人信息
                </a></li>
                </ul></li>

            <li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
                <span>扩展功能</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>
            </a>
                <ul class="treeview-menu">

                    <li><a
                            href="${pageContext.request.contextPath}/admin/log"> <i
                            class="fa fa-circle-o"></i> 访问日志
                    </a></li>
                    <li><a
                            href="#">
                        <i class="fa fa-circle-o"></i>其他
                    </a></li>

                </ul></li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
