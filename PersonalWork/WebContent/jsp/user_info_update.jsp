<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>TOPページ</title>
<jsp:include page="/baselayout/head.html" />
</head>
<body>
	<div id="container">
      <jsp:include page="/baselayout/header.jsp" />
      <main>
      	<div id="login_form">
          <form action="index.html" method="POST">
            <p class="letter">お名前</p>
            <p><input type="text" name="name" style="width:293px"></p>
            <p class="letter">ログインID</p>
            <p><input type="text" name="loginId" style="width:293px"></p>
            <p class="letter">生年月日</p>
            <p><input type="date" name="birthDate" style="padding-left:5px;border-radius: 5px;width: 293px;"></p>
            <p class="letter">パスワード</p>
            <p><input type="password" name="password" style="width:293px"></p>
            <p class="letter">パスワード(確認)</p>
            <p><input type="password" name="password" style="width:293px"></p>
            <button>
              <div id="login_button">更新</div>
            </button>
          </form>
        </div>
      </main>
      <jsp:include page="/baselayout/footer.jsp" />
    </div>
</body>
</html>