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
        <table id="purchase_history">
          <tr>
            <th>商品</th><th>個数</th><th>単価</th><th>レビューを書く</th>
          </tr>
          	<c:forEach var="bh" items="${bhList}">
	          <tr>
	            <td>${bh.name}</td><td>${bh.overlappedNum}</td><td>${bh.price}円</td><td><a href="/PersonalWork/Review?id=${bh.itemId}"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
	          </tr>
	        </c:forEach>
          <tr>
            <td></td><td style="font-weight:bold;">合計</td><td style="font-weight:bold;">${bhList.get(0).totalPrice}円</td><td></td>
          </tr>
        </table>
      </main>
      <jsp:include page="/baselayout/footer.jsp" />
    </div>
</body>
</html>