<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客詳細</title>
</head>
<body>
<h1>顧客詳細</h1>

<%--
    Customer custObj  = (Customer) request.getAttribute("customer");
    
    if (custObj != null) {
--%>
<p><strong>会社名：</strong>高橋工業</p>
<p><strong>名前：</strong> 高橋　威博</p>
<p><strong>誕生日：</strong> 8月20日</p>
<p><strong>LINE ID：</strong> </p>
<p><strong>キープボトル：</strong> 山崎１２年</p>
<p><strong>ゴルフをするか：</strong> する </p>
<p><strong>メモ</strong></p>
<div style="border:solid 2px #000;width:300px;height:100px;">横幅300px×高さ100px</div><br>
<p><strong>登録日：</strong> 2025/06/24</p>

<p>来店履歴<br>
<a href="visitList.jsp">一覧</a><br>
<a href="visitRegister.jsp">登録</a>
</p>
</body>
</html>