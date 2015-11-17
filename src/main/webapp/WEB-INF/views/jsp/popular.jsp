<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<jsp:include page="common/header.jsp"/>



<%@ page import="org.jinstagram.Instagram" %>
<%@ page import="org.jinstagram.entity.users.feed.MediaFeed" %>
<%@ page import="org.jinstagram.entity.users.feed.MediaFeedData" %>
<%@ page import="java.util.List" %>
<%@ page import="com.morenkov.ee.morestat.utils.constants.Constants" %>


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
                <li class="active"><a href="popular">Популярное</a></li>
                <li><a href="search">Поиск</a></li>
                <li><a href="logout">Выйти</a></li>
            </ul>
        </div>
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-12">
            <h1 class="page-header">Popular Media</h1>
        </div>
        <%

            MediaFeed mediaFeed = instagram.getPopularMedia();
            List<MediaFeedData> mediaList = mediaFeed.getData();
            int mediaCount = mediaList.size();
        %>

        <h3>Media Count :  <%=mediaCount%>
        </h3>

        <%
            for (MediaFeedData mediaFeedData : mediaList) {

        %>
        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
            <a class="thumbnail" href="#">
                <img class="img-responsive" src="<%=mediaFeedData.getImages().getLowResolution().getImageUrl()%>"
                     alt="">
            </a>
        </div>

        <%
            }
        %>


    </div>

<jsp:include page="common/footer.jsp"/>