<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="common/header.jsp"/>
<jsp:include page="common/navigationbar.jsp"/>


<!-- Page Content -->
<div class="layout__content">
    <div class="profile">
        <div class="profile__info">
            <div class="user__avatar">
                <img class="user__avatar__img" src="${userInfoData.profilePicture}"/> <br/>
            </div>
            <div class="user__media">
                <span class="bold_text">${userInfoData.getCounts().follows}</span>
            <span class="general_text">
                <spring:message code="morestat.profile-page.followers" text="Followers"/>
            </span>
                <br/>
            <span>
                <span class="bold_text">${userInfoData.getCounts().followedBy}</span>
                    <span class="general_text">
                        <spring:message code="morestat.profile-page.following" text="Following"/>
                    </span>
            </span>
                <br/>
            <span>
                <span class="bold_text">${userInfoData.getCounts().media}</span>
                    <span class="general_text">
                        <spring:message code="morestat.profile-page.posts" text="Posts"/>
                    </span>
            </span>
            </div>
            <div class="user__stat">
                <div>
                    <span class="total_likes"></span>
                    <span class="bold_text">${totalLikes}</span>
                </div>
                <div>
                    <span class="total_comments"></span>
                <span class="bold_text">
                    ${totalComments}
                </span>
                </div>
            </div>
        </div>
        <div class="photo_feed">
            <c:forEach items="${sortedByLikesMedia}" var="media">
                <div class="photo-container">
                    <div>
                        <img src="${media.images.standardResolution.imageUrl}" alt="insta-image" class="insta-image"/>
                    </div>
                    <div class="photo-info">
                        <span class="likes-count">${media.likes.count}</span>
                        <span class="comment-count">${media.comments.count}</span>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

<jsp:include page="common/footer.jsp"/>