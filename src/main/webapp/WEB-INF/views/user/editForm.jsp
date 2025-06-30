<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mysite.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user.css">
    </head>

    <body>
       <div class="wrap">
            <!-- header ---------------------------------------------->
	        <c:import url="/WEB-INF/views/include/header.jsp"></c:import>
	        <!-- header ---------------------------------------------->
                 
            <nav>
                <ul class="clearfix">
                    <li><a href="">입사지원서</a></li>
                    <li><a href="">게시판</a></li>
                    <li><a href="">갤러리</a></li>
                    <li><a href="">방명록</a></li>
                </ul>
            </nav>

            <div class="content2 clearfix">
                <aside>
                    <h2>유저</h2>
                    <ul>
                        <li><a href="">회원정보</a></li>
                        <li><a href="">로그인</a></li>
                        <li><a href="">회원가입</a></li>
                    </ul>
                </aside>


                <main>
                    <div class="main-head clearfix">
                        <h3>회원정보</h3>
                        <ol class="clearfix">
                            <li>홈</li>
                            <li>유저</li>
                            <li>회원정보</li>
                        </ol>
                    </div>

                    <div id="user-editform">
                        
                        <form class="form-box" action="${pageContext.request.contextPath}/user/edit" method="get">
                            <div class="info-row">
                                <span class="info-title">아이디</span>
                                <span id="txt-id">${requestScope.userVO.id}</span>
                            </div>
                            <div class="info-row">
                                <label class="info-title" for="txt-pwd">패스워드</label>
                                <input id="txt-pwd" type="password" name="password" value="${requestScope.userVO.password}">
                            </div>
                            <div class="info-row">
                                <label class="info-title" for="txt-name">이름</label>
                                <input id="txt-name" type="text" name="name" value="${requestScope.userVO.name}">
                            </div>
                            <div class="info-row">
                                <span class="info-title">성별</span>
                                <label>남</label>
                                <c:if test= "${requestScope.userVO.gender == 'male'}">
                                	<input type = "radio" name="gender" value="male" checked="checked">
                                </c:if>
                                
                                <c:if test= "${requestScope.userVO.gender != 'male'}">
                                	<input type = "radio" name="gender" value="male" checked="">
                                </c:if>
                               
                                
                                <label>여</label>
                                <c:if test= "${requestScope.userVO.gender == 'female'}">
                                	<input type = "radio" name="gender" value="female" checked="checked">
                                </c:if>
                                
                                <c:if test= "${requestScope.userVO.gender != 'female'}">
                                	<input type = "radio" name="gender" value="female" checked="">
                                </c:if>
                            </div>
                            <div class="btn-group">
                                <button id="btn-edit" class="btn btn-blue btn-lg" type="submit">회원정보수정</button>
                            </div>
                        </form>
                        
                    </div>

                    
                </main>
            </div>
            
            <!-- footer ---------------------------------------------->
	        <c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	        <!-- footer ---------------------------------------------->

        </div>
     
    </body>
</html>