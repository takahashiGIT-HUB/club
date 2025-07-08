<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>来店履歴編集</title>
</head>
<body>

<h2>${customer.name} さんの来店履歴を編集</h2>

<form action="visitHistoryUpdate" method="post">
    <input type="hidden" name="historyId" value="${history.id}">
    <input type="hidden" name="customerId" value="${customer.id}">

    <label>来店日：
        <input type="date" name="visitDate" value="${history.visitDate}" required>
    </label><br><br>

    <label>ボトル名：
        <input type="text" name="bottle" value="${history.bottle}">
    </label><br><br>

    <label>金額（円）：
        <input type="number" name="amount" min="0" value="${history.amount}">
    </label><br><br>

    <label>指名：
        <input type="radio" name="nominated" value="true" ${history.nominated ? "checked" : ""}> あり
        <input type="radio" name="nominated" value="false" ${!history.nominated ? "checked" : ""}> なし
    </label><br><br>

    <label>メモ：<br>
        <textarea name="memo" rows="4" cols="40">${history.memo}</textarea>
    </label><br><br>

    <button type="submit">更新</button>
</form>

<br>
<a href="visitHistoryList.jsp?customerId=${customer.id}">← 来店履歴一覧に戻る</a>

</body>
</html>
