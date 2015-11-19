<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <li <c:if test="${activeTab == 'profile'}">class="active" </c:if><a href="profile"><spring:message code="morestat.main-page.profile" text="profile"/></a></li>
        <li <c:if test="${activeTab == 'gallery'}">class="active" </c:if>><a href="gallery"><spring:message code="morestat.main-page.gallery" text="gallery"/></a></li>
        <li <c:if test="${activeTab == 'popular'}">class="active" </c:if>><a href="popular"><spring:message code="morestat.main-page.popular" text="popular"/></a></li>
        <li <c:if test="${activeTab == 'search'}">class="active" </c:if>><a href="search"><spring:message code="morestat.main-page.search" text="search"/></a></li>
        <li <c:if test="${activeTab == 'logout'}">class="active" </c:if>><a href="logout"><spring:message code="morestat.main-page.logout" text="logout"/></a></li>
      </ul>
            <span class="nav navbar-nav navbar-right">
                <c:if test="${not empty  authorizationUrl}">
                    <a href="${authorizationUrl}"
                       role="button" class="btn btn-primary navbar-btn">
                        <img src="resources/images/instagram-512.png" class="insta-ico"/>
                        <span>Войти в инстаграм</span>
                    </a>
                </c:if>
                <span>
                    <img src="resources/images/rusFlag.png" id="russianLanguage" class="insta-ico" alt="Russian language"/>
                    <img src="resources/images/engFlag.png" id="englishLanguage" class="insta-ico" alt="English language"/>
                </span>
            </span>
    </div>
  </div>
</nav>