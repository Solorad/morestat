<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="common/header.jsp"/>

<%@ page import="org.jinstagram.Instagram" %>

<%@ page import="org.jinstagram.entity.users.basicinfo.UserInfoData" %>
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
            <a class="navbar-brand" href="#">MORESTAT</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="profile"><spring:message code="morestat.main-page.profile" text="profile"/></a></li>
                <li><a href="gallery"><spring:message code="morestat.main-page.gallery" text="gallery"/></a></li>
                <li><a href="popular"><spring:message code="morestat.main-page.popular" text="popular"/></a></li>
                <li><a href="search"><spring:message code="morestat.main-page.search" text="search"/></a></li>
                <li><a href="logout"><spring:message code="morestat.main-page.logout" text="logout"/></a></li>
            </ul>
            <span class="nav navbar-nav navbar-right">
                <span>
                    <img src="resources/images/rusFlag.png" id="russianLanguage" class="insta-ico" alt="Russian language"/>
                    <img src="resources/images/engFlag.png" id="englishLanguage" class="insta-ico" alt="English language"/>
                </span>
            </span>
        </div>
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-12">
            <h1 class="page-header">User Profile</h1>
        </div>
        <%UserInfoData userInfoData = instagram.getCurrentUserInfo().getData();%>
        <p class="lead">
            <img src="<%=userInfoData.getProfilePicture()%>"/> <br/>
        <p>Username : <%=userInfoData.getUsername()%></p>

        <% if (userInfoData.getWebsite() != null){%>
        <p>Сайт: <%=userInfoData.getWebsite()%></p>
        <%}%>
        <p>Follows : <%=userInfoData.getCounts().getFollows()%></p>
        <p>Followed By : <%=userInfoData.getCounts().getFollowedBy()%>
        </p>
        <p>Media Count : <%=userInfoData.getCounts().getMedia()%></p>
    </div>

<jsp:include page="common/footer.jsp"/>