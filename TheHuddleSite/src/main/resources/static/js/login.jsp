
<html xmlns:th="http://www.thymeleaf.org">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="messages" />
<fmt:message key="message.password" var="noPass" />
<fmt:message key="message.username" var="noUser" />
<c:if test="${param.regSucc == true}">
    <div id="status">
        <spring:message code="message.regSucc">
        </spring:message>
    </div>
</c:if>
<c:if test="${param.regError == true}">
    <div id="error">
        <spring:message code="message.regError">
        </spring:message>
    </div>
</c:if>
<c:if test="${param.error != null}">
<div id="error">
    <spring:message code="message.badCredentials">
    </spring:message>
</div>
</c:if>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <title>The Huddle:The Best Social Media Site For Football</title>
    <link rel="stylesheet" href="/css/login.css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div id="login-page">
    <div class="login-page-container">
        <h1 class="title">Login</h1>
        <form id="usernameForm" name="usernameForm">
            <div class="form-group">
                <input type="text" id="username" placeholder="Username" autocomplete="off" class="form-control" />
            </div>
        </form>
        <form id="passwordForm" name="passwordForm">
            <div class="form-group">
                <input type="text" id="password" placeholder="Password" autocomplete="off" class="form-control" />
            </div>
            <div class="form-group">
                <button type="submit" class="accent login-submit" onclick = "href='/main.html'">Sign In!</button>
            </div>
            <div class="form-group">
                <link type="submit" class="accent registration-submit">Don't Have an Account? <a href="/signup"> Register Here!</a></link>
            </div>
        </form>


        <a href="/restricted" class="btn btn-primary">Restricted</a>
    </div>
</div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<script src="/js/login.js"></script>
</body>
</html>