<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<jsp:include page="common/header.jsp"/>
<spring:url value="/resources/css/index.css" var="indexCss"/>
<link href="${indexCss}" rel="stylesheet"/>
</head>

<body>
<jsp:include page="common/navigationbar.jsp"/>
<div class="container-fluid">
    <div class="layout__content">
        <h1>Сбор статистики Instagram</h1>
        <p>
            Узнайте сколько лайков вы получили, ваше самое популярное фото, среднее число лайков и комментариев к
            фото.
            Изменение числа фолловеров и многое другое.
        </p>
    </div>
</div>

<jsp:include page="common/footer.jsp"/>