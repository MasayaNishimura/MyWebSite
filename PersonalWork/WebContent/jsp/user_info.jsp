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
        <h1>お客様情報</h1>
        <table id="user_info">
          <tr>
            <th>お名前</th><th>ログインID</th><th>登録日</th>
          </tr>
          <tr>
            <td>${userInfoDetail.name}</td><td>${userInfoDetail.loginId}</td><td>${userInfoDetail.createDate}</td>
          </tr>
          <tr>
            <td colspan="3">
              <form action="/PersonalWork/UserInfoUpdate">
                <button>
                  <div id="user_info_update_btn">登録情報変更</div>
                </button>
              </form>
            </td>
          </tr>
        </table>
        <h1>購入履歴</h1>
        <table id="purchase_history">
          <tr>
            <th>購入日</th><th>金額</th><th>詳細</th>
          </tr>
          <c:forEach var="buy" items="${buyHistory}">
	          <tr>
	            <td>${buy.buyDate}</td><td>${buy.totalPrice}円</td><td><a href="BuyHistoryDetail?id=${buy.id}"><i class="fa fa-external-link" aria-hidden="true"></i></a></td>
	          </tr>
          </c:forEach>
        </table>
      </main>
      <jsp:include page="/baselayout/footer.jsp" />
    </div>
</body>
</html>