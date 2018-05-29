<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>ログインページ</title>
<jsp:include page="/baselayout/head.html" />
<%
String errMsg = (String) request.getAttribute("errMsg");
%>
</head>
<body>
	<div id="container">
      <jsp:include page="/baselayout/header.jsp" />
      <main>
      	<% if(errMsg != null) { %>
      	<h1 style="color:red;"><%= errMsg %></h1>
      	<% } %>
        <div id="login_form">
          <form action="/PersonalWork/Login" method="POST">
            <p class="letter">ログインID</p>
            <p><input type="text" name="loginId" style="width:295px;"></p>
            <p class="letter">パスワード</p>
            <p><input type="password" name="password" style="width:295px;"></p>
            <button>
              <div id="login_button">ログイン</div>
            </button>
          </form>
        </div>
      </main>
      <jsp:include page="/baselayout/footer.jsp" />
    </div>
</body>
</html>