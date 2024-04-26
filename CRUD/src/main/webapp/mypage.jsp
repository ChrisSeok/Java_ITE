<%@ page import="member.vo.MemberVO" language="java"
	contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>����������</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
/* �߰����� ��Ÿ�ϸ��� ���⿡ �ۼ��ϼ��� */
.profile-icon {
	font-size: 5rem;
	color: #6c757d; /* ȸ�� */
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
			<!-- ȸ���� ū ���׶� �ι� ������ -->
			<h2 class="mt-3">����������</h2>
			<br><br>
			
			<%
				MemberVO meminfo = (MemberVO) session.getAttribute("USERVO");
				if (meminfo != null) {
			%>

			<p>
			<!-- ������ �α��� ���̵� -->
				���̵�:
				<%= meminfo.getUser_loginid() %></p>
			
			<p>
			<!-- ������ �̸� -->
				�̸�:
				<%= meminfo.getUser_name() %></p>
			
			
			<br><br>
			
			<!-- ȸ�� Ż��� ȸ�� ���� ���� ��ư -->
			<a href="deletemember" class="btn btn-danger mr-2">ȸ�� Ż��</a> 
			<a href="editmember.jsp" class="btn btn-primary">ȸ�� ���� ����</a> 
			<a href="mypostservlet" class="btn btn-post">���� �� ��</a>


			<% }%>
		</div>
	</div>


	<!-- Font Awesome -->
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</body>
</html>
