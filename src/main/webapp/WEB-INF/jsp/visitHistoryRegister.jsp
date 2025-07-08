<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Customer" %>
<%
    // 顧客情報（登録フォームの対象）がリクエストスコープにある想定
    Customer customer = (Customer) request.getAttribute("customer");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>来店履歴登録</title>
</head>
<body>

<h2><%= customer.getName() %> さんの来店履歴を登録</h2>

<form action="visitHistoryCreate" method="post">
    <input type="hidden" name="customerId" value="<%= customer.getId() %>">

    <label>来店日：
        <input type="date" name="visitDate" required>
    </label><br><br>

    <label>ボトル名：
        <input type="text" name="bottle">
    </label><br><br>

    <label>金額（円）：
        <input type="number" name="amount" min="0">
    </label><br><br>

    <label>指名：
        <input type="radio" name="nominated" value="true" > あり
        <input type="radio" name="nominated" value="false" checked> なし
    </label><br><br>

    <label>メモ：<br>
        <textarea name="memo" rows="4" cols="40"></textarea>
    </label><br><br>

    <button type="submit">登録</button>
</form>

<!-- 戻るリンク -->
<br>
<a href="visitHistoryList.jsp?customerId=<%= customer.getId() %>">← 来店履歴一覧に戻る</a>

</body>
</html>
