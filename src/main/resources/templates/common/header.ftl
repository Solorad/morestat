<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Morestat">
    <meta name="author" content="Morenkov Evgenii">
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>Morestat, analytic tool</title>

    <link href="/images/favicon.png" rel="shortcut icon"/>
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>

