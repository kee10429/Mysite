<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
        <link rel="stylesheet" href="../../assets/css/reset.css">
        <link rel="stylesheet" href="../../assets/css/mysite.css">
        <link rel="stylesheet" href="../../assets/css/board.css">
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
                    <h2>게시판</h2>
                    <ul>
                        <li><a href="">일반게시판</a></li>
                        <li><a href="">댓글게시판</a></li>
                    </ul>
                </aside>

                <main>
                    <div class="main-head clearfix">
                        <h3>일반게시판</h3>
                        <ol class="clearfix">
                            <li>홈</li>
                            <li>게시판</li>
                            <li>일반게시판</li>
                        </ol>
                    </div>
                    
                    <div id="board-writeform">
                
                        <form class="form-box" action="#" method="get">
							<!-- 제목 -->
							<div class="info-row">
								<label class="info-title" for="txt-title">제&nbsp;&nbsp;&nbsp;목</label>
								<input type="text" id="txt-title" name="" value="" placeholder="제목을 입력해 주세요">
							</div>
						
							<!-- 내용 -->
							<div class="info-row">
								<textarea id="txt-content"></textarea>
							</div>
							
                            <div class="btn-box">
							    <a class="btn btn-gray btn-md" href="">목록</a>
							    <button class="btn btn-blue btn-md" type="submit" >등록</button>
							</div>
						</form>
						<!-- //form -->

                    </div>

                    
                </main>
            </div>
            
             <!-- footer ---------------------------------------------->
	        <c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	        <!-- footer ---------------------------------------------->

        </div>
     
    </body>
</html>