<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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


<jsp:include page="common/header.jsp"/>
<jsp:include page="common/navigationbar.jsp"/>


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