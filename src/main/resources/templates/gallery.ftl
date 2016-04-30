<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<%@ page import="org.jinstagram.Instagram" %>
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

<jsp:include page="common/header.ftl"/>
<jsp:include page="common/navigationbar.ftl"/>

<!-- Page Content -->
<div class="container">
  <div class="row">
    <div class="col-lg-12">
      <h1 class="page-header">Gallery</h1>
    </div>
    <%
      List<MediaFeedData> mediaList = instagram.getUserFeeds().getData();

    %>

    <h3>Media Count :  <%=mediaList.size()%>
    </h3>

    <%
      for (MediaFeedData mediaFeedData : mediaList) {


    %>
    <div class="col-lg-3 col-md-4 col-xs-6 thumb">
      <a class="thumbnail" href="#">
        <img class="img-responsive" src="<%=mediaFeedData.getImages().getLowResolution().getImageUrl()%>"
             alt="">
      </a>
    </div>

    <%
      }
    %>


  </div>
<jsp:include page="common/footer.ftl"/>