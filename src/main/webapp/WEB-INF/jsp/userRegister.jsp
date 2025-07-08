<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<h2>ユーザー登録</h2>
<form action="UserRegister" method="post">
<label>
	ユーザー名
	<input type="text" name="userName" required><br>
</label>
<label>
	パスワード
	<input type="password" name="pass" required>
</label>
<button type="submit">登録</button>
</form>
</body>
</html>