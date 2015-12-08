<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="common/header.jsp"/>
<jsp:include page="common/navigationbar.jsp"/>


<!-- Page Content -->
<div class="container">
    <div class="userInfo">
        <div class="insta-info">
            <img class="user-avatar" src="${userInfoData.profilePicture}"/> <br/>

            <div class="media-descr">
                <span class="general-info">${userInfoData.getCounts().follows}</span>
                <span class="general-info-description">
                    <spring:message code="morestat.profile-page.followers" text="Followers"/>
                </span>

                <div>
                    <span class="general-info">${userInfoData.getCounts().followedBy}</span>
                    <span class="general-info-description">
                        <spring:message code="morestat.profile-page.following" text="Following"/>
                    </span>
                </div>
                <div>
                    <span class="general-info">${userInfoData.getCounts().media}</span>
                    <span class="general-info-description">
                        <spring:message code="morestat.profile-page.posts" text="Posts"/>
                    </span>
                </div>
            </div>
        </div>

        <div class="stat-info">
            <div>
                <span class="general-info-description">
                    <spring:message code="morestat.profile-page.total-likes" text="Total likes"/>
                </span>
                <span class="general-info">${totalLikes}</span>
            </div>
            <div>
                <span class="general-info-description">
                    <spring:message code="morestat.profile-page.total-comments" text="Total comments"/>
                </span>
                <span class="general-info">
                    ${totalComments}
                </span>
            </div>
        </div>

        <div class="popularComments">
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