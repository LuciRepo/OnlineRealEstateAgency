<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>MENIU BANCI - Tables</title>

  <!-- Custom fonts for this template -->
  <link href="${pageContext.request.contextPath}/resources/sb-admin2/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/sb-admin2/resources/css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="${pageContext.request.contextPath}/resources/sb-admin2/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>
<body>

<!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="home.htm">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Home <sup></sup></div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      
      <!-- Divider -->
      

      <!-- Heading -->
      

      <!-- Nav Item - Pages Collapse Menu -->
      

      <!-- Nav Item - Utilities Collapse Menu -->
      

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>Operations</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">RealEstate Management</h6>
            <a class="collapse-item" href="addRealEstate.htm">Add a new Real Estate </a>
           
            
        </div>
      </li>

      <!-- Nav Item - Charts -->
      

      <!-- Nav Item - Tables -->
      

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Topbar Search -->
          

          <!-- Topbar Navbar -->
          

        </nav>
        <!-- End of Topbar -->
        

<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0"><b>Registered real estate property</b></td></table>


<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
  <tr>
  <td style="text-align: center;padding-left:0px"><b></>Address</b></td>
  <td style="text-align: center; padding-left: 0px"><b>Transaction Status</b></td>
  <td style="text-align: center; padding-left: 0px"><b>Sqm</b></td> 
  <td style="text-align: center; padding-left: 0px"><b>Description</b></td> 
  <td style="text-align: center; padding-left: 0px"><b>SalePrice</b></td>
  <td style="text-align: center; padding-left: 0px"><b>RentPrice</b></td>
 <%-- <td style="text-align: center; padding-left: 5px"><a href="">RentPrice&nbsp;</a></td>  --%>
  </tr>
  </table>
<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

<c:forEach items="${model.realEstateList}" var="re">
<tr>
	<td><c:out value="${re.address}"/></td>
    <td><c:out value="${re.statusOfTransaction}"/></td>
    <td><c:out value="${re.areaSqm}"/><td>
    <td><c:out value="${re.description}"/><td>
    <td><c:out value="${re.salePrice}"/><td>
    <td><c:out value="${re.rentPrice}"/><td>
  <%--   <td><a href="./photosRealEstate/${re.id}">Photos</a></td> --%>
    <td><a href="./editRealEstate/${re.id}">Edit</a></td>
    <td><a href="./deleteRealEstate/${re.id}">Delete</a></td>
    <td><a href="./rentRealEstate/${re.id}">Rent</a></td>
    </tr>
</c:forEach>
</table>

<!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/sb-admin2/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/sb-admin2/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/sb-admin2/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="${pageContext.request.contextPath}/resources/sb-admin2/resources/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="${pageContext.request.contextPath}/resources/sb-admin2/resources/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/sb-admin2/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="${pageContext.request.contextPath}/resources/sb-admin2/resources/js/demo/datatables-demo.js"></script>
</body>
</html>