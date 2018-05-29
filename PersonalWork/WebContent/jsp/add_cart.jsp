<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>ログインページ</title>
<jsp:include page="/baselayout/head.html" />
</head>
<body>
	<div id="container">
      <jsp:include page="/baselayout/header.jsp" />
      <main>
      <h1>商品をカートに追加しますか</h1>
      <h1 style="color:red;">${errMsg}</h1>
        <div id="add_product_info">
          <div class="add_product">Sample</div>
          <p>${item.name}</p>
          <p>${item.price}円</p>
        </div>
        <div id="add_form">
          <form action="/PersonalWork/Cart" method="GET">
          <p style="margin:0 0 20px 0;">個数：<input type="number" name="itemNum" value="1" style="width:50px; text-align:right; padding-right:5px;"></p>
            <button type="submit" value="cancel"><div class="add_btn">戻る</div></button>
            <button type="submit" value="${item.id}" name="add"><div class="add_btn">追加する</div></button>
          </form>
        </div>
        <div id="review_list">
        <c:if test="${reviewList.size() != 0}">
        	<c:forEach var="review" items="${reviewList}">
	          <div class="review_item">
	            <p style="color:gold">${review.star}</p>
	            <p>${review.review}</p>
	          </div>
	         </c:forEach>
	         </c:if>
	         <c:if test="${reviewList.size() == 0}">
	         	<p style="text-align:center;">レビューはまだありません</p>
	         </c:if>
        </div>
      </main>
      <jsp:include page="/baselayout/footer.jsp" />
    </div>
</body>
</html>