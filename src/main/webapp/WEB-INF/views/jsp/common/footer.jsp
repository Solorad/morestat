<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- Footer -->
<footer class="footer">
    <div class="container-fluid">
        <hr>
        <p><a href="http://vk.com/solorad">Morenkov Evgenii</a> 2016</p>
    </div>
</footer>


<!-- /.container -->

<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs"/>
<spring:url value="/resources/js/developed/general.js" var="generalJs"/>

<script>var baseUrl = "${pageContext.request.contextPath}"</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${bootstrapJs}"></script>
<script src="${generalJs}"></script>

</body>

</html>
