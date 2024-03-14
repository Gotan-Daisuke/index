<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello world</title>
</head>
<body>
	<c:if test="${not empty result}">
		<c:out value="${result}"/>
	</c:if>
    <form method="post" action="./HelloWorld">
        名前を入力してください: <input type="text" name="name">
        パスワードを入力してください：<input type="text" name="password">
        <button type="submit">送信</button>
    </form>
</body>
</html>