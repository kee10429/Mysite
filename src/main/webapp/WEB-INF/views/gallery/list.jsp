<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
        <link rel="stylesheet" href="../../assets/css/reset.css">
        <link rel="stylesheet" href="../../assets/css/mysite.css">
        <link rel="stylesheet" href="../../assets/css/gallery.css">
    </head>

    <body>
      <div class="wrap">
            <header class="clearfix">
                <h1><a href="">MySite</a></h1>
              
               	<!--  로그인 되었을때(세션값 있을때) -->
               	<c:if test="${sessionScope.authUser != null}">
				    <ul class="clearfix">
					    <li><span class="user-welcome">${sessionScope.authUser.name}님 안녕하세요^^</span></li>
					    <li>
	                        <a class="btn btn-white btn-sm" href="${pageContext.request.contextPath}">로그아웃</a>
	                    </li>
	                    <li>
	                        <a class="btn btn-white btn-sm" href="${pageContext.request.contextPath}">회원정보수정</a>
	                    </li>
				    </ul>
			    </c:if>
               
               <!-- 로그인 되지 않았을때	-->
               <c:if test="${sessionScope.authUser == null}">
	               <ul class="clearfix">       
	                    <li>
	                        <a class="btn btn-white btn-sm" href="${pageContext.request.contextPath}/loginForm">로그인</a>
	                    </li>
	                    <li>
	                        <a class="btn btn-white btn-sm" href="">회원가입</a>
	                    </li>
	                </ul>
            	</c:if>  
            </header>


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
                    <h2>갤러리</h2>
                    <ul>
                        <li><a href="">일반갤러리</a></li>
                        <li><a href="">첨부파일연습</a></li>
                    </ul>
                </aside>

				<main>
                    <div class="main-head clearfix">
                        <h3>일반갤러리</h3>
                        <ol class="clearfix">
                            <li>홈</li>
                            <li>갤러리</li>
                            <li>일반갤러리</li>
                        </ol>
                    </div>
                    
					<!-- 버튼 -->
                    <div id="gallery-list">
                    <c:if test="${sessionScope.authUser != null}">
                        <div class="btn-box">
                            <button id="btnUploadOpen" class="btn btn-blue btn-md" type="button">이미지올리기</button>
                        </div>
                    </c:if>    
                        <ul class="clearfix">
							
							<!-- 이미지반복영역 -->
							<c:forEach var="galleryVO" items="${galleryList}">
	                            <li>
	                                <div id=uploadProfile class="card" >
	                                    <img src="${pageContext.request.contextPath}/upload/${galleryVO.saveName}">
	                                    <div class="writer">
	                                        작성자: <strong>${galleryVO.name}</strong>
	                                    </div>
	                                </div>
	                            </li>
                            </c:forEach>
                            
							<!-- 이미지반복영역 -->
							
						</ul>
                    </div>
                    
                </main>
            </div>
            
            <footer>
                <p>
                    Copyright ⓒ 2025 황일영. All right reserved  
                </p>
            </footer>

        </div>

        



<!-- 모달창 -->
<!-- 업로드 모달창 -->
 
<div id="modal-upload" class="modal-bg" style="display:none;">

	<div class="modal-content" >
    
        <div class="clearfix">
            <button id="btnUploadClose" class="btn-close">X</button>
        </div>
        
		<p class="title">이미지등록 모달창</p>
		
		<form id="imgupload-form" action="${pageContext.request.contextPath}/gallery/upload" method="post" enctype="multipart/form-data">
			<div class="info-row">
                <label for="txt-content">글작성</label>
				<input id="txt-content" type="text" name="content" value="">
			</div>

            <div class="info-row">
                <label for="txt-file">이미지선택</label>
				<input type="file" name="file">
			</div>
            <div class="btn-box">
			    <button type="submit" class="btn-del btn btn-blue btn-md">등록</button>
            </div>
        </form>
		
	</div>

</div>



<!-- 이미지보기 모달창 -->

<div id="modal-view" class="modal-bg active" style="display:none;">

	<div class="modal-content" >
    
        <div class="clearfix">
            <button id="btnViewClose" class="btn-close">X</button>
        </div>
        
		<p class="title">이미지보기 모달창</p>
		
		<div id="img-view">
            <img src="${pageContext.request.contextPath}/upload/${requestScope.saveName}">>


            <div class="img-content">
                여기는 입력한 코멘트가 나옵니다.
            </div>

            <div class="btn-box">
			    <button type="submit" class="btn-del btn btn-blue btn-md">삭제</button>
            </div>

        </div>
			
		
	</div>

</div>


<!-- ------------------------------------------------------ -->    
<script src="${pageContext.request.contextPath}/assets/js/jquery/jquery-3.7.1.js"></script>
<script>
	$(document).ready(function(){
		//열기버튼 클릭 시 모달창 나옴
		$("#btnUploadOpen").on("click", function(){
			$("#modal-upload").show();
		});
		
		//닫기버튼 클릭시 모달 창 숨기기
		$("#btnUploadClose").on("click", function(){
			$("#modal-upload").hide();
		});
		
	});
	
	$(document).ready(function(){
		//프로필 클릭시 모달창 나옴
		$(".card").on("click", function(){
			$("#modal-view").show();
		});
		
		$("#btnViewClose").on("click", function(){
			$("#modal-view").hide();
		});
		
	})
	




</script>

    </body>
</html>