<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

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

<jsp:include page="common/header.jsp"/>
<div class="jumbotron">
    <div class="container">
        <jsp:include page="common/navigationbar.jsp"/>
        <h1>Сбор статистики Instagram</h1>

        <p>
            Узнайте сколько лайков вы получили, ваше самое популярное фото, среднее число лайков и комментариев к фото.
            Изменение числа фолловеров и многое другое.
        </p>

    </div>
</div>

<div class="container">

<jsp:include page="common/footer.jsp"/>