<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="common/header.jsp"/>
<jsp:include page="common/navigationbar.jsp"/>


<!-- Page Content -->
<div class="container">
    <div class="userInfo">
        <img class="user-avatar" src="${userInfoData.profilePicture}"/> <br/>

        <div>
            <div class="media-descr">
                <span class="general-info">${userInfoData.getCounts().follows}</span>
                <span class="general-info-description"><spring:message code="morestat.profile-page.followers" text="Followers"/></span>
            <div>
                <span class="general-info">${userInfoData.getCounts().followedBy}</span>
                <span class="general-info-description"><spring:message code="morestat.profile-page.following" text="Following"/></span>
            </div>
            <div>
                <span class="general-info">${userInfoData.getCounts().media}</span>
                <span class="general-info-description"><spring:message code="morestat.profile-page.posts" text="Posts"/></span>
            </div>
        </div>

<jsp:include page="common/footer.jsp"/>