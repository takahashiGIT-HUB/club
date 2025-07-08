<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
   <title>新規顧客登録</title>
</head>
<body>
<h1>新規顧客登録</h1>

<form action="CustomerRegister" method="post">

    <label>会社名：
        <input type="text" name="companyName"><br>
    </label>

    <label>名前：
        <input type="text" name="name" required><br>
    </label>

    <label>誕生日：
        <input type="date" name="birthday"><br>
    </label>

    <label>LINE ID：
        <input type="text" name="lineId"><br>
    </label>

    <label>キープボトル：
        <input type="text" name="keepBottle"><br>
    </label>

    <label>ゴルフ：
        <input type="radio" name="likesGolf" value="true">する
        <input type="radio" name="likesGolf" value="false" checked>しない<br>
    </label>

    <label>メモ：<br>
        <textarea name="memo" rows="4" cols="40"></textarea><br>
    </label>

    <button type="submit">登録</button>
</form>

</body>
</html>
