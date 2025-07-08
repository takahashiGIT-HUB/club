<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<h1>ログイン</h1>
<form action="${pageContext.request.contextPath}/CustomerList" method="get">
	<label>
	ユーザー名
	<input type="text" name="userName" required><br>
	</label>
	<label>
		パスワード
		<input type="password" name="pass" required><br>
	</label>
	<button type="submit">ログイン</button> 
</form>
<p>アカウントをお持ちでない方は <a href="UserRegister">こちら</a> から登録</p>

<% if (request.getAttribute("error") != null) { %>
   <p style="color:red;"><%= request.getAttribute("error") %></p>
<% } %>
</body>
</html>