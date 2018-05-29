<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
	<% boolean isLogin = session.getAttribute("userInfo")!=null?true:false; %>
	<a id="home" href="/PersonalWork">LIKEIT<i class="fa fa-home" aria-hidden="true"></i></a>
	<div id="header_div_right">
		<% if(!isLogin) { %>
		<a href="/PersonalWork/NewUser"><i class="fa fa-user-plus" aria-hidden="true"></i></a>
		<% } %>
		<% if(!isLogin) { %>
		<a href="/PersonalWork/Login"><i class="fa fa-sign-in" aria-hidden="true"></i></a>
		<% }else{ %>
		<a href="/PersonalWork/Logout"><i class="fa fa-sign-out" aria-hidden="true"></i></a>
		<% } %>
		<% if(isLogin) { %>
		<a href="/PersonalWork/Cart"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
		<a href="/PersonalWork/UserInfo"><i class="fa fa-user-circle" aria-hidden="true"></i></a>
		<% } %>
	</div>
 </header>