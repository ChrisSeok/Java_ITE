<%@ page import="member.vo.MemberVO" language="java"
	contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
/* 추가적인 스타일링은 여기에 작성하세요 */
.profile-icon {
	font-size: 5rem;
	color: #6c757d; /* 회색 */
}
.btn-post{
	background-color: #6c757d;
	color: white;
}
</style>
</head>
<body>

	<div class="container mt-5">
		<div class="text-center">
			<i class="fas fa-user-circle profile-icon"></i>
			<!-- 회색의 큰 동그란 인물 아이콘 -->
			<h2 class="mt-3">마이페이지</h2>
			<br><br>
			
			<%
				MemberVO meminfo = (MemberVO) session.getAttribute("USERVO");
				if (meminfo != null) {
			%>

			<p>
			<!-- 유저의 로그인 아이디 -->
				아이디:
				<%= meminfo.getUser_loginid() %></p>
			
			<p>
			<!-- 유저의 이름 -->
				이름:
				<%= meminfo.getUser_name() %></p>
			
			
			<br><br>
			
			<!-- 회원 탈퇴와 회원 정보 수정 버튼 -->
			<a href="deletemember" class="btn btn-danger mr-2">회원 탈퇴</a> 
			<a href="editmember.jsp" class="btn btn-primary">회원 정보 수정</a> 
			<a href="mypostservlet" class="btn btn-post">내가 쓴 글</a>


			<% }%>
		</div>
	</div>


	<!-- Font Awesome -->
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</body>
</html>
