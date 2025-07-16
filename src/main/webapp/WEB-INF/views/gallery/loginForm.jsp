<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <h2>로그인</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        아이디: <input type="text" name="id"><br>
        비밀번호: <input type="password" name="password"><br>
        <button type="submit">로그인</button>
    </form>
    

</body>
</html>