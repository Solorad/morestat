<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="A basic web application demonstrating the use of jInstagram API.">
    <meta name="author" content="Morenkov Evgenii">
    <title>Morestat, analytic tool</title>

    <spring:url value="/resources/css/bootstrap-theme.min.css" var="bootstrapThemeCss"/>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/resources/css/mainPage.css" var="mainPageCss"/>
    <spring:url value="/resources/images/favicon.ico" var="favicon"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${bootstrapThemeCss}" rel="stylesheet"/>
    <link href="${mainPageCss}" rel="stylesheet"/>
    <link href="${favicon}" rel="shortcut icon"/>
</head>

<body>
