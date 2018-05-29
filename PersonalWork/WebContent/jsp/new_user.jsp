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
      <% if (errMsg != null) { %>
      <h1 style="color:red;"><%= errMsg %></h1>
      <% } %>
      	<div id="login_form">
          <form action="/PersonalWork/NewUser" method="POST">
            <p class="letter">お名前</p>
            <p><input type="text" name="name" required style="width:295px;"></p>
            <p class="letter">ログインID</p>
            <p><input type="text" name="loginId" required style="width:295px;"></p>
            <p class="letter">生年月日</p>
            <p><input type="date" name="birthDate" style="border-radius:5px;width:295px;" required></p>
            <p class="letter">パスワード</p>
            <p><input type="password" name="password" required style="width:295px;"></p>
            <p class="letter">パスワード(確認)</p>
            <p><input type="password" name="passwordConfirm" required style="width:295px;"></p>
            <button>
              <div id="login_button">登録</div>
            </button>
          </form>
        </div>
      </main>
      <jsp:include page="/baselayout/footer.jsp" />
    </div>
</body>
</html>