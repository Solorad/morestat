<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<jsp:include page="common/header.jsp"/>



<%@ page import="org.jinstagram.Instagram" %>
<%@ page import="org.jinstagram.entity.tags.TagMediaFeed" %>
<%@ page import="org.jinstagram.entity.users.feed.MediaFeed" %>
<%@ page import="org.jinstagram.entity.users.feed.MediaFeedData" %>
<%@ page import="java.util.List" %>
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
            <h1 class="page-header">Search</h1>
        </div>

        <p>

        <form action="search" method="post">
            Tag # <input type="text" name="tag"/> &nbsp; <input type="submit" name="submit" value="Submit">

            <input type="hidden" name="searchType" value="tag"/>

        </form>
        </p>


        <%
            List<MediaFeedData> mediaList = null;
            String errMessage = null;
            int mediaCount = 0;
            TagMediaFeed tagMediaFeed = null;

            if (request.getParameter("submit") != null) {
                if (request.getParameter("searchType").equals("tag")) {

                    String tag = request.getParameter("tag");

                    if (tag != null || tag.trim().length() != 0) {
                        try {
                            tagMediaFeed = instagram.getRecentMediaTags(tag);

                            mediaList = tagMediaFeed.getData();

                            MediaFeed recentMediaNextPage = instagram.getRecentMediaNextPage(tagMediaFeed.getPagination());
                            int counter = 0;
                            while (recentMediaNextPage.getPagination() != null && counter < Constants.MAX_PAGE_SIZE) {
                                mediaList.addAll(recentMediaNextPage.getData());

                                recentMediaNextPage = instagram.getRecentMediaNextPage(recentMediaNextPage.getPagination());

                                counter++;
                            }

                            mediaCount = mediaList.size();

                        } catch (Exception ex) {
                            errMessage = ex.getMessage();
                        }
                    }
                }
            }


        %>

        <% if (errMessage != null) { %>
        <div class="alert alert-danger" role="alert">
            <%= errMessage %>
        </div>
        <% } %>


        <%
            if (mediaList != null) {
        %>
        <h3>Media Count :  <%=mediaCount%>
        </h3>

        <div class="alert alert-warning" role="alert">
            <strong>Note :</strong>Max page size is set to <%= Constants.MAX_PAGE_SIZE %>

        </div>
        <%
            for (MediaFeedData mediaFeedData : mediaList) {

        %>
        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
            <a class="thumbnail" href="#">
                <img class="img-responsive" src="<%=mediaFeedData.getImages().getLowResolution().getImageUrl()%>"
                     alt="">
            </a>
        </div>

        <% }
        }
        %>
    </div>

<jsp:include page="common/footer.jsp"/>