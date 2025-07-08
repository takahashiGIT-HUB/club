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

<%
    Customer custObj  = (Customer) request.getAttribute("customer");
    
    if (custObj != null) {
%>
<p><strong>会社名：</strong> ${customer.companyName}</p>
<p><strong>名前：</strong> ${customer.name}</p>
<p><strong>誕生日：</strong> ${customer.birthday}</p>
<p><strong>LINE ID：</strong> ${customer.lineId}</p>
<p><strong>キープボトル：</strong> ${customer.keepBottle}</p>
<p><strong>ゴルフをするか：</strong> 
<%
	boolean likesGolf = false;
	if(custObj instanceof Customer){
		likesGolf = ((Customer)custObj).isLikesGolf
	}

%>    
<%= likesGolf ? "はい" : "いいえ" %>
    </p>
    <p><strong>メモ</strong> </p>
    <div style="border:solid 2px #000;width:300px;height:100px;">
      ${customer.memo}</div><br>
    <p><strong>登録日：</strong> ${customer.createdAt}</p>

    
  <a href="customerList.jsp">← 顧客一覧に戻る</a>
</body>
</html>