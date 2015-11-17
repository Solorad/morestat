<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<jsp:include page="common/header.jsp"/>

<%@ page import="com.morenkov.ee.morestat.utils.constants.Constants" %>
<%@ page import="org.jinstagram.auth.oauth.InstagramService" %>

<%
    Object objInstagram = session.getAttribute(Constants.INSTAGRAM);
    if (objInstagram != null) {
        response.sendRedirect(request.getContextPath() + "/profile");
    }
    InstagramService instagramService = (InstagramService) session.getAttribute(Constants.INSTAGRAM_SERVICE);
    String authorizationUrl = instagramService.getAuthorizationUrl(null);
%>

<div class="jumbotron">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <span><a class="navbar-brand" href="#">MORESTAT</a></span>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="profile">Профиль</a></li>
                        <li><a href="gallery">Галлерея</a></li>
                        <li><a href="popular">Популярное</a></li>
                        <li><a href="search">Поиск</a></li>
                    </ul>
                    <span class="nav navbar-nav navbar-right">
                        <a href="<%= authorizationUrl%>"
                           role="button" class="btn btn-primary navbar-btn">
                            <img src="resources/images/instagram-512.png" class="insta-ico"/>
                            <span>Войти в инстаграм</span>
                        </a>
                        <span>
                            <img src="resources/images/rusFlag.png" id="russianLanguage" class="insta-ico" alt="Russian language"/>
                            <img src="resources/images/engFlag.png" id="englishLanguage" class="insta-ico" alt="English language"/>
                        </span>
                    </span>
                </div>
            </div>
        </nav>
        <h1>Сбор статистики Instagram</h1>

        <p>
            Узнайте сколько лайков вы получили, ваше самое популярное фото, среднее число лайков и комментов к фото.
            Изменение числа фолловеров и многое другое.
        </p>

    </div>
</div>

<div class="container">

<jsp:include page="common/footer.jsp"/>