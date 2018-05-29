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
        <div id="product_review">
          <div style="margin-bottom:0;">Sample</div>
          <p style="margin-bottom:40px;">商品名：${item.name}</p>
          <form action="" method="POST">
            <textarea placeholder="Your review here!" name="review"></textarea>
            <br>
            <select id="rating" name="rating">
              <option value="★">☆</option>
              <option value="★★">☆☆</option>
              <option value="★★★" selected>☆☆☆</option>
              <option value="★★★★">☆☆☆☆</option>
              <option value="★★★★★">☆☆☆☆☆</option>
            </select>
            <button>送信</button>
          </form>
        </div>
      </main>
      <jsp:include page="/baselayout/footer.jsp" />
    </div>
</body>
</html>