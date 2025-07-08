<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客一覧</title>
</head>
<body>
<a href="CustomerRegister">新規登録</a><br>

 <!-- 検索フォーム -->
<form action="customerList" method="get">
     名前で検索：
     <input type="text" name="keyword" value="${keyword}" />
     <input type="submit" value="検索" />
</form>
<br>
 <table border="1">
 	<tr>
 		<th>ID</th>
 		<th>会社名</th>
 		<th>名前</th>
 		<th>誕生日</th>
 		<th>最終来店日</th>
 		<th>操作</th>
 	</tr>
 	
 	<%
 		java.util.List customerList = (java.util.List) request.getAttribute("customerList");
       if (customerList != null) {
     	  for (int i = 0; i < customerList.size(); i++) {
        	  request.setAttribute("c", customerList.get(i));
     %>
     	<tr>
     		<td>${c.id}</td>
     		<td>${c.companyName}</td>
     		<td>${c.name}</td>
     		<td>${c.birthday}</td>
     		 <td>${c.lastVisitDate}</td>
     		<td>
     			<a href="customerDetail?id=${c.id}">詳細</a>
     			<a href="customerEdit?id=${c.id}">編集</a>
     			 <a href="customerDelete?id=${c.id}" onclick="return confirm('削除しますか？');">削除</a>
            </td>
         </tr>
  <%
      }
    }
  %>
</table>
</body>
</html>