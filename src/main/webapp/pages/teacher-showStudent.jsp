<%--
  Created by IntelliJ IDEA.
  User: 15181
  Date: 2020/12/2
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>课程管理</title>
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

    <script>
        function delCourse(id){
            if(confirm("您确认要删除吗")){
                location.href="${pageContext.request.contextPath}/teacher/deleteStudent?uid="+id;
            }
        };
        function addStudent(courseId){
            let id = prompt("输入学号：");
            if (id!=null){
                location.href="${pageContext.request.contextPath}/teacher/addStudent?cid="+courseId+"&uid="+id;
            }
        }
    </script>

</head>

<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="teacher-header.jsp"></jsp:include>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="teacher-aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                课程管理 <small>课程</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/pages/teacherMain.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/teacher/showCourse">查看已开设课程</a></li>

                <li class="active">学生信息</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content"> <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">${requestScope.msg}</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建" onclick="addStudent(${requestScope.cid})">
                                        <i class="fa fa-file-o"></i> 添加
                                    </button>
                                    <button id="js-export" class="btn btn-default" type="button" >导出Excel</button>

                                </div>
                            </div>
                        </div>
                     <%--   <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm" id="findStudentByIdOrName"
                                       placeholder="搜索"> <span
                                    class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </div>--%>
                        <!--工具栏/-->

                        <!--数据列表-->
                        <table id="dataList"
                               class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="" style="padding-right: 0px"><input
                                        id="selall" type="checkbox" class="icheckbox_square-blue">
                                </th>
                                <th class="sorting_asc1"><label class = "sortById" id="sortById" >学号</label></th>
                                <th class="sorting_desc1">姓名</th>
                                <th >专业</th>
                                <th >年纪</th>
                                <th class="sorting_desc" id="sortByScore"><label class="sortByScore" id="sortByScoreValue" >分数</label></th>

                                <th >操作</th>
                            </tr>
                            </thead>

                            <tbody id="content">
                            <c:forEach items="${requestScope.users}" var="user">
                                <tr>
                                    <td><input name="ids" type="checkbox"></td>
                                    <td>${user.id}</td>
                                    <td>${user.username}</td>
                                    <td>${user.major}</td>
                                    <td>${user.grade}</td>
                                    <td>${user.score}</td>
                                   <%-- <td class="text-center">
                                        <c:forEach items="${user.roles}" var="role">
                                            &nbsp;&nbsp;${role.roleName}
                                        </c:forEach>
                                    </td>--%>
                                    <td class="text-center">
                                        <a  onclick="delCourse(${user.id})" class="btn bg-olive btn-xs">删除</a>
                                        <a href="#" class="btn bg-olive btn-xs" onclick="showDetail(${user.id},${requestScope.cid},${user.score})" id="score">打分或修改分数</a>
                                    </td>
                                </tr>
                            </c:forEach>



                            </tbody>

                        </table>
                        <!--数据列表/-->

                    </div>
                    <!-- 数据表格 /-->

                </div>
                <!-- /.box-body -->

                <%--弹出打分输入框--%>
                <form action="${pageContext.request.contextPath}/teacher/saveScore" METHOD="post">
                    <div id="updateScore" style="display: none;background-color: rgb(241,243,244);
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
                                    <td >学号:</td>
                                    <td><input type="text" id="user_id" name="uid" value="" style="width: 300px;height: 30px;outline: none;"></td>
                                </tr>
                                <tr>
                                    <td>课程编号:</td>
                                    <td><input id="course_id" type="text" readonly="true" name="cid" value="" style="width: 300px;height: 30px;outline: none" ></td>
                                </tr>
                                <tr>
                                    <td>分数:</td>
                                    <td><input id="course_score" type="text" name="score" style="width: 300px;height: 30px;outline: none"></td>
                                </tr>
                            </table>
                            <div style="margin-top:20px;position: relative;left:103px;"><input type="submit" style="width: 80px;height: 30px;outline: none" value="确定"></div>
                        </div>
                    </div>
                </form>
            </div>

        </section>
        <!-- 正文区域 /-->

    </div>


    <!-- @@close -->
    <!-- 内容区域 /-->
    <!-- 底部导航 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.8
        </div>
        <strong>Copyright &copy; 2018-2020 <a
                href="http://www.itcast.cn">研究院研发部</a>.
        </strong> All rights reserved. </footer>
    <!-- 底部导航 /-->

</div>



<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="../plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="../plugins/raphael/raphael-min.js"></script>
<script src="../plugins/morris/morris.min.js"></script>
<script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="../plugins/knob/jquery.knob.js"></script>
<script src="../plugins/daterangepicker/moment.min.js"></script>
<script src="../plugins/daterangepicker/daterangepicker.js"></script>
<script src="../plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
<script
        src="../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="../plugins/fastclick/fastclick.js"></script>
<script src="../plugins/iCheck/icheck.min.js"></script>
<script src="../plugins/adminLTE/js/app.min.js"></script>
<script src="../plugins/treeTable/jquery.treetable.js"></script>
<script src="../plugins/select2/select2.full.min.js"></script>
<script src="../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="../plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="../plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="../plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="../plugins/ckeditor/ckeditor.js"></script>
<script src="../plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="../plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="../plugins/chartjs/Chart.min.js"></script>
<script src="../plugins/flot/jquery.flot.min.js"></script>
<script src="../plugins/flot/jquery.flot.resize.min.js"></script>
<script src="../plugins/flot/jquery.flot.pie.min.js"></script>
<script src="../plugins/flot/jquery.flot.categories.min.js"></script>
<script src="../plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="../plugins/bootstrap-slider/bootstrap-slider.js"></script>
<%--分数降序排序--%>
<script>
    $(document).ready(function () {
        let a = document.getElementById("sortByScoreValue");
        let b = document.getElementById("sortByScore");
        b.onclick = function () {
            //获取数据
            $.ajax({
                url: "${pageContext.request.contextPath}/teacher/student/order",
                data: {"value": a.innerHTML},
                success: function (data) {
                    var html = "";
                    for (let i = 0; i < data.length; i++) {
                        html += "<tr>" +
                            "<td>" + "<input name='ids' type='checkbox'>" + "</td>" +
                            "<td>" + data[i].id + "</td>" +
                            "<td>" + data[i].username + "</td>" +
                            "<td>" + data[i].major + "</td>" +
                            "<td>" + data[i].grade + "</td>" +
                            "<td>" + data[i].score + "</td>" +

                            "<td class='text-center'>" +
                            "<a class='btn bg-olive btn-xs' href="+"${pageContext.request.contextPath}/teacher/student/" + data[i].id+">"
                            + "删除" +  "</a>"+ "</td>" +
                            "<td class='text-center'>" +
                            "<a class='btn bg-olive btn-xs' href="+"${pageContext.request.contextPath}/teacher/student/saveScore" +">"
                            + "打分或修改分数" +  "</a>"+ "</td>" +
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

<script>
    //导出成绩
    $('#js-export').click(function(){

        window.location.href="${pageContext.request.contextPath}/teacher/exportStudents";
    });
</script>
<script>

    function showDetail(userid,cid,score) {
        $("#user_id").val(userid);
        $("#course_score").val(score);
        $("#course_id").val(cid);
        $("#updateScore").css("display", "block")
    }
   /* $(document).ready(function() {

        let a = document.getElementById("findStudentByIdOrName");

        }*/

        a.onblur = function () {
            //获取数据
            $.ajax({
                url: "${pageContext.request.contextPath}/teacher/findStudentByIdOrName",
                data: {"value": a.value},
                success: function (data) {
                    //console.log(a.value)
                    var html = "";
                    for (let i = 0; i < data.length; i++) {
                        html += "<tr>" +
                            //<td><input name="ids" type="checkbox"></td>
                            "<td>" + "<input name='ids' type='checkbox'>" + "</td>" +
                            "<td>" + data[i].id + "</td>" +
                            "<td>" + data[i].username + "</td>" +
                            "<td>" + data[i].major + "</td>" +
                            "<td>" + data[i].grade + "</td>" +
                            "<td>" + data[i].score + "</td>" +
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
            locale : 'zh-CN'

    });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document).ready(function() {

                // 激活导航位置
                setSidebarActive("admin-datalist");

                // 列表按钮
                $("#dataList td input[type='checkbox']")
                    .iCheck(
                        {
                            checkboxClass : 'icheckbox_square-blue',
                            increaseArea : '20%'
                        });
                // 全选操作
                $("#selall")
                    .click(
                        function() {
                            var clicks = $(this).is(
                                ':checked');
                            if (!clicks) {
                                $(
                                    "#dataList td input[type='checkbox']")
                                    .iCheck(
                                        "uncheck");
                            } else {
                                $(
                                    "#dataList td input[type='checkbox']")
                                    .iCheck("check");
                            }
                            $(this).data("clicks",
                                !clicks);
                        });
            });
</script>
</body>

</html>
