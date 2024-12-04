<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" class="light-style layout-menu-fixed" dir="ltr" data-theme="theme-default" data-assets-path="${pageContext.request.contextPath}/assets/" data-template="vertical-menu-template-free">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
  <title>Dashboard - Sneat Bootstrap 5 HTML Template</title>
  <meta name="description" content="">
  <meta name="keywords" content="">

  <!-- Preloaded Scripts -->
  <tiles:insertAttribute name="preScript" />

  <!-- Alert Message -->
  <c:if test="${not empty message}">
    <script type="text/javascript">
      alert("${message}");
    </script>
  </c:if>
</head>

<body>
  <!-- Layout Wrapper -->
  <div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">
      <!-- Sidebar -->
      <aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme">
        <tiles:insertAttribute name="sidebar" />
      </aside>
      <!-- /Sidebar -->

      <!-- Layout Page -->
      <div class="layout-page">
        <!-- Header -->
        <header id="layout-navbar" class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme">
          <tiles:insertAttribute name="header" />
        </header>
        <!-- /Header -->

        <!-- Content Wrapper -->
        <div class="content-wrapper">
          <!-- Main Content -->
          <main id="main" class="main">
            <tiles:insertAttribute name="content" />
          </main>
          <!-- /Main Content -->

          <!-- Footer -->
          <footer id="footer" class="content-footer footer bg-footer-theme">
            <tiles:insertAttribute name="footer" />
          </footer>
          <!-- /Footer -->

          <div class="content-backdrop fade"></div>
        </div>
        <!-- /Content Wrapper -->
      </div>
      <!-- /Layout Page -->
    </div>

    <!-- Layout Overlay -->
    <div class="layout-overlay layout-menu-toggle"></div>
  </div>
  <!-- /Layout Wrapper -->

  <!-- Back to Top Button -->
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center">
    <i class="bx bx-up-arrow-alt"></i>
  </a>

  <!-- Postloaded Scripts -->
  <tiles:insertAttribute name="postScript" />
</body>

</html>
