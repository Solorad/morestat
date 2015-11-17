<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<jsp:include page="common/header.jsp"/>


<%@ page import="com.morenkov.ee.morestat.utils.constants.Constants" %>
<%@ page import="org.jinstagram.Instagram" %>


<%

    Object objInstagram = session.getAttribute(Constants.INSTAGRAM);

    Instagram instagram = null;

    if (objInstagram != null) {
        instagram = (Instagram) objInstagram;
    } else {
        response.sendRedirect(request.getContextPath());
        return;
    }


%>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <span><a class="navbar-brand" href="#">MORESTAT</a></span>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="profile">Профиль</a></li>
                <li><a href="gallery">Галерея</a></li>
                <li><a href="popular">Популярное</a></li>
                <li><a href="search">Поиск</a></li>
                <li class="active"><a href="logout.jsp">Выйти</a></li>
            </ul>
        </div>
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-12">
            <h1 class="page-header">Logout</h1>
        </div>

        <div class="alert alert-success" role="alert">
            <strong>Well done!</strong> You've successfully ended the session. Please click here to <a
                href=<%=request.getContextPath()%>>login</a>
        </div>
    </div>

    <hr>


<jsp:include page="common/footer.jsp"/>