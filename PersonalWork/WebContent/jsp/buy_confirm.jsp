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
        <table id="buy_confirm">
          <tr>
            <th>商品名</th><th>単価</th><th>個数</th><th>小計</th>
          </tr>
          	<c:forEach var="item" items="${cartInItem}">
	          <tr>
	            <td>${item.name}</td><td>${item.price}円</td><td>${item.overLappedNum}</td><td>${item.price * item.overLappedNum}円</td>
	          </tr>
	        </c:forEach>
          <tr>
            <td></td><td></td><td></td><td>合計：${totalPrice}円</td>
          </tr>
        </table>
        <a href="/PersonalWork/BuyResult"><div id="buy_btn">購入する</div></a>
      </main>
      <jsp:include page="/baselayout/footer.jsp" />
    </div>
</body>
</html>