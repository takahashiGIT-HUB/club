<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>来店履歴一覧</title>
</head>
<body>

<%
  // 顧客情報の取得（事前にサーブレットでセットされている前提）
  Customer customer = (Customer) request.getAttribute("customer");
  List<VisitHistory> historyList = (List<VisitHistory>) request.getAttribute("historyList");
%>

<h1><%= customer.getName() %> さんの来店履歴</h1>

<!-- 顧客詳細ページへの戻り -->
<a href="customerDetail.jsp?id=<%= customer.getId() %>">← 顧客詳細へ戻る</a><br><br>

<!-- 履歴追加 -->
<a href="visitHistoryRegister.jsp?customerId=<%= customer.getId() %>">＋新規来店履歴追加</a><br><br>

<table border="1">
  <tr>
    <th>日付</th>
    <th>キープボトル</th>
    <th>金額</th>
    <th>指名あり</th>
    <th>メモ</th>
    <th>操作</th>
  </tr>

  <%
    if (historyList != null) {
      for (VisitHistory h : historyList) {
        request.setAttribute("h", h);
  %>
  <tr>
    <td>${h.visitDate}</td>
    <td>${h.bottle}</td>
    <td>${h.amount}</td>
    <td>${h.isNominated ? "あり" : "なし"}</td>
    <td>${h.memo}</td>
    <td>
      <a href="visitHistoryEdit.jsp?id=${h.id}">編集</a>
      <a href="visitHistoryDelete?id=${h.id}" onclick="return confirm('削除しますか？');">削除</a>
    </td>
  </tr>
  <%
      }
    } else {
  %>
    <tr><td colspan="6">履歴がありません</td></tr>
  <%
    }
  %>
</table>

</body>
</html>