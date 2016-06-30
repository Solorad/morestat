<#include "/common/header.ftl">
<link href="css/profile.css" rel="stylesheet"/>
<script type="text/javascript" src="/webjars/spin-js/2.1.0/spin.js"></script>
</head>

<body>
<#include "/common/navigationbar.ftl">


<!-- Page Content -->
<div class="container-fluid">
    <div class="layout__content">
        <div class="profile">
            <div class="profile__info">
                <div class="user__avatar">
                    <img class="user__avatar__img" src="${userInfoData.profilePicture}"/> <br/>
                </div>
                <div class="user__media">
                    <span class="bold_text">${userInfoData.getCounts().followedBy}</span>
                    <span class="general_text">
                        <@spring.message "morestat.profile-page.followers"/>
                    </span>
                    <br/>
                    <span>
                        <span class="bold_text">${userInfoData.getCounts().follows}</span>
                            <span class="general_text">
                                <@spring.message "morestat.profile-page.following"/>
                            </span>
                    </span>
                    <br/>
                    <span>
                        <span class="bold_text">${userInfoData.getCounts().media}</span>
                            <span class="general_text">
                                <@spring.message "morestat.profile-page.posts"/>
                            </span>
                    </span>
                </div>
                <#--<div class="user__stat">-->
                    <#--<div>-->
                        <#--<span class="total_likes"></span>-->
                        <#--<span class="bold_text">${totalLikes}</span>-->
                    <#--</div>-->
                    <#--<div>-->
                        <#--<span class="total_comments"></span>-->
                        <#--<span class="bold_text">-->
                        <#--${totalComments}-->
                        <#--</span>-->
                    <#--</div>-->
                <#--</div>-->
            </div>
            <div class="info" style="">
                <div class="totalInfo" id="spinner"></div>
            </div>
        <#--<div class="profile_cards">-->
                <#--<#list sortedByLikesMedia as media>-->
                    <#--<div class="profile_card">-->
                        <#--<div class="card">-->
                            <#--<div>-->
                                <#--<img src="${media.images.standardResolution.imageUrl}" alt="insta-image"-->
                                     <#--class="insta-image"/>-->
                            <#--</div>-->
                            <#--<div class="photo-info">-->
                                <#--<span class="likes-count">${media.likes.count}</span>-->
                                <#--<span class="comment-count">${media.comments.count}</span>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</#list>-->
            <#--</div>-->
        </div>
    </div>
</div>

<#include "/common/footer.ftl">
<script type="text/javascript" src="/js/profile.js"></script>
</body>
</html>
