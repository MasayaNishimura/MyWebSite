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
        <h1>購入が完了しました</h1>
        <div id="buy_result">
          <a href="/PersonalWork/Index"><div>引き続き買い物をする</div></a>
          <a href="/PersonalWork/UserInfo"><div>購入履歴へ</div></a>
        </div>
        <div style="width:80%; margin:100px auto 0;">
          <p>この商品を購入した人はこんな商品も購入しています</p>
          <ul id="others_buy">
            <li>
              <a href="/PersonalWork/AddCart"><div class="others_buy_item">Sample</div></a>
              <p>商品名</p>
              <p>値段</p>
            </li>
          </ul>
        </div>
      </main>
      <jsp:include page="/baselayout/footer.jsp" />
    </div>
</body>
</html>