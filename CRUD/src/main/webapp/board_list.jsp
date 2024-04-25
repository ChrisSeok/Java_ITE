
<%@ page import="java.util.List, board.vo.BoardVO" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<h2 class="mt-5 mb-4">게시글 목록</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">게시글 ID</th>
					<th scope="col">사용자 ID</th>
					<th scope="col">제목</th>
					<th scope="col">생성 시간</th>
				</tr>
			</thead>
			<tbody>

				<% List<BoardVO> postlist = (List<BoardVO>) session.getAttribute("PostList");%>
				<%if (postlist != null) { %>
				<% for (BoardVO post : postlist) {  %>
				<div class="post">
					<tr>
						<%--게시글id, 유저id, 제목, 글 생성시간 리스트로 표시 --%>
						<td><%= post.getPost_id() %></td>
						<td><%= post.getUser_id() %></td>

						<td><a href="getpost?postid=<%= post.getPost_id() %>"><%= post.getTitle() %></a></td>

						<td><%= post.getCreated_at() %></td>
					</tr>
					<% } %>
					<% } %>
				
			</tbody>
		</table>
	</div>
	<!-- Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

