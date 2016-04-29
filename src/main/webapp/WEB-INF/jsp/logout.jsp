<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<jsp:include page="common/header.jsp"/>
<jsp:include page="common/navigationbar.jsp"/>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-12">
            <h1 class="page-header">Logout</h1>
        </div>

        <div class="alert alert-success" role="alert">
            <strong>Well done!</strong> You've successfully ended the session. Please click here to <a
                href=<%=request.getContextPath()%>>login</a>
        </div>
    </div>

    <hr>

<jsp:include page="common/footer.jsp"/>