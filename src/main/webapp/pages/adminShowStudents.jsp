<%--
  Created by IntelliJ IDEA.
  User: 15181
  Date: 2020/12/2
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>管理员端</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">

    <!-- Tell the browser to be responsive to screen width -->
    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="admin-header.jsp"></jsp:include>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="admin-aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">
        <section class="content"> <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <%--    <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">

                                        <button type="button" class="btn btn-default" href="#" title="添加">
                                            <i &lt;%&ndash;class="fa fa-refresh"&ndash;%&gt;></i> 添加
                                        </button>
                                    </div>
                                </div>
                            </div>--%>
                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm" id="searchStudent"
                                       placeholder="搜索"> <span
                                    class="glyphicon glyphicon-search form-control-feedback" id="searchS"></span>

                            </div>
                        </div>
                        <!--工具栏/-->

                        <!--数据列表-->
                        <table id="dataList"
                               class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="sorting_asc">学号</th>
                                <th class="sorting_desc">姓名</th>
                                <th class="sorting_asc sorting_asc_disabled">密码</th>
                                <th class="sorting_desc sorting_desc_disabled">性别</th>
                                <th class="sorting_desc sorting_desc_disabled">系别</th>
                                <th class="sorting_desc sorting_desc_disabled">专业</th>
                                <th class="sorting_desc sorting_desc_disabled">年纪</th>
                                <th class="sorting_desc sorting_desc_disabled">电话</th>
                                <th class="sorting_desc sorting_desc_disabled">操作</th>
                                <%-- <th class="sorting">具有角色</th>
                                 <th class="sorting">操作</th>--%>
                            </tr>
                            </thead>
                            <tbody id="content">
                            <c:forEach items="${requestScope.users.list}" var="user">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.username}</td>
                                    <td>${user.password}</td>
                                    <td>${user.gender}</td>
                                    <td>${user.department}</td>
                                    <td>${user.major}</td>
                                    <td>${user.grade}</td>
                                    <td>${user.tel}</td>
                                        <%--  <td class="text-center">
                                              <c:forEach items="${requestScope.courses}" var="course1">
                                                  &nbsp;&nbsp;${course1.courseName}
                                              </c:forEach>
                                          </td>--%>
                                    <td class="text-center">
                                        <a href="${pageContext.request.contextPath}/admin/student/updateR?id=${user.id}"
                                           class="btn bg-olive btn-xs">修改</a>
                                    </td>
                                    <td class="text-center">
                                        <a href="${pageContext.request.contextPath}/admin/student/course?id=${user.id}"
                                           class="btn bg-olive btn-xs">课程</a>
                                    </td>
                                    <td class="text-center" >
                                        <a  onclick="deleteUser(${user.id})"  class="btn bg-olive btn-xs">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>


                            </tbody>

                        </table>
                        <!--数据列表/-->
                        <div class="box-tools pull-right">
                            <ul class="pagination">
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/student?page=${requestScope.users.pageNum-1}&size=${requestScope.users.pageSize}">首页</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/student?page=1&size=${requestScope.users.pageSize}">上一页</a>
                                </li>
                                <c:forEach begin="1" end="${requestScope.users.pages}" var="pageNum">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/admin/student?page=${pageNum}&size=${requestScope.users.pageSize}">${pageNum}</a>
                                    </li>
                                </c:forEach>
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/student?page=${requestScope.users.pageNum+1}&size=${requestScope.users.pageSize}">下一页</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/student?page=${requestScope.users.pages}&size=${requestScope.users.pageSize}">尾页</a>
                                </li>
                            </ul>

                        </div>
                    </div>
                    <!-- 数据表格 /-->

                </div>
                <!-- /.box-body -->

            </div>

        </section>


    </div>


    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.8
        </div>
        <strong>Copyright &copy; 2014-2017 <a
                href="https://www.nsu.edu.cn/">东软首页</a>.
        </strong> All rights reserved.
    </footer>
    <!-- 底部导航 /-->

</div>
<script>
    function deleteUser(userId){
        if(confirm("您确认要删除吗")){
            location.href="${pageContext.request.contextPath}/admin/student/delete?id="+userId;
        }
    }
</script>
<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script>
    $(document).ready(function () {
        let a = document.getElementById("searchStudent");
        let b = document.getElementById("searchS");
        a.onkeyup   = function () {
            //获取数据
            $.ajax({
                url: "${pageContext.request.contextPath}/admin/student/searchStudent",
                data: {"value": a.value},
                success: function (data) {
                    //console.log(a.value)
                    var html = "";
                    for (let i = 0; i < data.length; i++) {
                        html += "<tr>" +
                            //<td><input name="ids" type="checkbox"></td>

                            "<td>" + data[i].id + "</td>" +
                            "<td>" + data[i].username + "</td>" +
                            "<td>" + data[i].password + "</td>" +
                            "<td>" + data[i].gender + "</td>" +
                            "<td>" + data[i].department + "</td>" +
                            "<td>" + data[i].major + "</td>" +
                            "<td>" + data[i].grade + "</td>" +
                            "<td>" + data[i].tel + "</td>" +
                                "<td class='text-center'>" +
                                    "<a class='btn bg-olive btn-xs' href="+"${pageContext.request.contextPath}/admin/student/updateR?id=" + data[i].id+">"
                                    + "修改" +  "</a>"+ "</td>" +
                            "<td class='text-center'>" +
                            "<a class='btn bg-olive btn-xs' href="+"${pageContext.request.contextPath}/admin/student/course?id=" + data[i].id+">"
                            + "课程" +  "</a>"+ "</td>" +
                            "<td class='text-center'>" +
                            "<a class='btn bg-olive btn-xs' href="+"${pageContext.request.contextPath}/admin/student/delete?id=" + data[i].id+">"
                            + "删除" +  "</a>"+ "</td>" +
                            "</tr>"
                    }
                    $("#content").html(html);
                }
            });
        };


        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });

        function delUser() {
            if (confirm("您确定要删除吗？")) {
                return true;
            }
        }
    });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document).ready(function () {
        // 激活导航位置
        setSidebarActive("admin-index");
    });
</script>
</body>

</html>
