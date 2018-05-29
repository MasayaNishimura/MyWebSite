<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Item"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>TOPページ</title>
<jsp:include page="/baselayout/head.html" />
<%
ArrayList<Item> itemList = (ArrayList<Item>) session.getAttribute("cartInItem");
%>
</head>
<body>
	<div id="container">
      <jsp:include page="/baselayout/header.jsp" />
      <main>
        <h1>買い物かご</h1>
        <c:if test="${cartInItem.size() == 0 || cartInItem == null}">
        <p id="cart_status">商品はありません</p>
        </c:if>
        <c:if test="${cartInItem.size() != 0}">
        <p id="cart_status">商品が${totalNum}点あります</p>
        </c:if>
        <div style="width:450px;margin:40px auto;">
        <form action="/PersonalWork/Cart" method="GET">
          <button name="emptyCart" style="font-family:'Yu Mincho';"><div id="empty_cart">カートを空にする</div></button>
          <button name="buy" style="font-family:'Yu Mincho'; margin-left:20px;"><div id="buy">レジに進む</div></button>
          </form>
        </div>
        <div id="cart_contents">
	        <% for (int i = 0; i < itemList.size(); i++) { %>
	          <div class="cart_product">
	            <div><a href="product_detail.html" class="product_img">Sample</a></div>
	            <div class="product_name"><%= itemList.get(i).getName() + "　×" +  itemList.get(i).getOverLappedNum()%></div>
	            <div class="product_pricce"><%= itemList.get(i).getPrice() %>円</div>
	            <form action="/PersonalWork/Cart" method="GET">
	              <button type="submit" name="delete" value="<%= i %>"><div class="delete_btn">削除</div></button>
	            </form>
	          </div>
	        <% } %>
        </div>
      </main>
      <jsp:include page="/baselayout/footer.jsp" />
    </div>
</body>
</html>