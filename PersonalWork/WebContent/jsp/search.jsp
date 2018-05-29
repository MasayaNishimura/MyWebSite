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
      	<div class="product_search">
          <form action="/PersonalWork/Search" method="GET">
            <div style="margin-bottom:15px;">
              価格：
              <input type="number" name="sProductPrice" class="product_price_search">
              ～
              <input type="number" name="eProductPrice" class="product_price_search">
            </div>
            <div>
              商品検索：<input type="text" name="product_search" class="search_text">
              <button class="search_button" type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
            </div>
          </form>
        </div>
      	<c:if test="${referItemList.size() != 0}">
      		<p style="text-align: center; margin: 50px 0;">検索結果</p>
      	</c:if>
      	<c:if test="${referItemList.size() == 0}">
      		<p style="text-align: center; margin: 50px 0;">該当なし</p>
      	</c:if>
        <ul id="products">
	      <c:forEach var="referItem" items="${referItemList}">
	        <li>
	          <div><a href="/PersonalWork/AddCart?id=${referItem.id}" class="product_img">Sample</a></div>
	          <div class="product_info">
	            <span>${referItem.name}</span><span style="margin-left:20px;">${referItem.price}円</span>
	            <p>商品説明～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～</p>
	          </div>
	        </li>
          </c:forEach>
        </ul>
      </main>
      <jsp:include page="/baselayout/footer.jsp" />
    </div>
</body>
</html>