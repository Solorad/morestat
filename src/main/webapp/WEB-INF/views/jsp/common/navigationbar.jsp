<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Navigation -->

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#">MORESTAT</a>
        </div>

        <div class="collapse navbar-collapse">
            <c:if test="${empty  authorizationUrl}">
                <ul class="nav navbar-nav">
                    <li <c:if test="${activeTab == 'profile'}">class="active" </c:if>><a href="profile">
                        <spring:message code="morestat.main-page.profile" text="profile"/></a></li>
                    <li <c:if test="${activeTab == 'gallery'}">class="active" </c:if>><a href="gallery"><spring:message
                            code="morestat.main-page.gallery" text="gallery"/></a></li>
                    <li <c:if test="${activeTab == 'popular'}">class="active" </c:if>><a href="popular"><spring:message
                            code="morestat.main-page.popular" text="popular"/></a></li>
                    <li <c:if test="${activeTab == 'search'}">class="active" </c:if>><a href="search"><spring:message
                            code="morestat.main-page.search" text="search"/></a></li>
                    <li <c:if test="${activeTab == 'logout'}">class="active" </c:if>><a href="logout"><spring:message
                            code="morestat.main-page.logout" text="logout"/></a></li>
                </ul>
            </c:if>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${not empty  authorizationUrl}">
                    <li>
                        <a href="${authorizationUrl}" class="updated_padding">
                            <img src="resources/images/instagram-512.png" width="32px"/>
                            <span><spring:message code="morestat.main-page.button.login"
                                                  text="Войти в инстаграмм"/></span>
                        </a>
                    </li>
                </c:if>
                <li>
                    <a href="?lang=ru" class="updated_padding">
                        <div class="header__language_rus"></div>
                    </a>
                </li>
                <li>
                    <a href="?lang=en" class="updated_padding">
                        <div class="header__language_eng"></div>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>