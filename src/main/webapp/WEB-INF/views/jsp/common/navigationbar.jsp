<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Navigation -->

<div class="header">
    <!-- Brand and toggle get grouped for better mobile display -->
    <h2 class="header__title">
        <a class="navbar-brand" href="#">MORESTAT</a>
    </h2>

    <div class="collapse navbar-collapse">
        <c:if test="${empty  authorizationUrl}">
            <ul class="navigation">
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
        <span class="header__right">
            <c:if test="${not empty  authorizationUrl}">
                <a href="${authorizationUrl}"
                   role="button" class="btn btn-primary navbar-btn">
                    <img src="resources/images/instagram-512.png" class="insta-ico"/>
                    <span><spring:message code="morestat.main-page.button.login" text="Войти в инстаграмм"/></span>
                </a>
            </c:if>
            <span>
                <a href="?lang=ru">
                    <div class="header__language header__language_rus"></div>
                    <div class="header__language header__language_eng"></div>
                </a>
                <a href="?lang=en">
                    <button id="englishLanguageButton" type="button" class="btn btn-default language-chooser"
                            value="en">
                        <div class="header__language header__language_eng"></div>
                        <img src="resources/images/engFlag.png" id="englishLanguage" class="insta-ico"
                             alt="English language"/>
                    </button>
                </a>
            </span>
        </span>
    </div>
</div>