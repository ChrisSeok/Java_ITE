<%@ page import="board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시글 수정</title>
<!-- 부트스트랩 CDN 링크 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl5+z9rU+lcTzoIyFkLegdsiK/KOQ/h02KLb5t9iiC"
	crossorigin="anonymous">
<style>
body {
	padding: 20px;
}

.post-container {
	margin-bottom: 30px;
}

.post-header {
	background-color: #f8f9fa;
	padding: 25px;
	border-bottom: 1px solid #dee2e6;
}

.post-content {
	padding: 20px;
	border: 1px solid #dee2e6;
	border-radius: 5px;
	background-color: #fff;
}

.large-box {
	padding: 20px;
	border: 2px solid #007bff;
	border-radius: 10px;
	background-color: #f0f8ff;
}

.btn-primary {
	background-color: #28a745; /* 초록색 */
	color: #fff;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	text-decoration: none;
	transition: text-decoration 0.3s;
	text-align: right;
	float: right; /* 우측 정렬 */
	margin-top: 20px; /* 버튼과 다른 내용 사이 간격 조정 */
}

.btn-primary:hover {
	text-decoration: underline;
}

.form-control {
	border: 1px solid #ced4da; /* 입력 필드 테두리 스타일 */
	border-radius: .25rem; /* 입력 필드 테두리 둥글기 */
	height: 30px;
	width: 100%;
}

.bg-beige {
	background-color: #f5f5dc; /* 베이지색 */
}

.text-right {
	text-align: right;
}

.textarea {
	height: 250px;
	width: 100%;
}
</style>



</head>
<body>

	<div class="container">
		<h1 class="mt-5">게시글 수정</h1>
		<div class="post-container">
			<div class="post-header"></div>
			<div class="post-content bg-beige">
				<!-- 베이지색 배경 추가 -->
				<%
				BoardVO postinfo = (BoardVO) session.getAttribute("POSTINFO");
				String username = (String) session.getAttribute("USERNAME");
				if (postinfo != null) {
				%>
				<form action="editprocessservlet" method="post">

					<div class="mb-3 row">
						<label for="title" class="col-sm-2 col-form-label"
							style="display: block; font-weight: bold;"> 제목 </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="title"
								name="editted_title" value="<%=postinfo.getTitle()%>">
						</div>
						<input type="hidden" name="post_id"
							value="<%=postinfo.getPost_id()%>">

					</div>


					<div class="mb-3">
						<label for="content" class="form-label"
							style="display: block; font-weight: bold;"> 내용 </label>
						<textarea class="form-control textarea" id="content"
							name="editted_content" rows="10"><%=postinfo.getContent()%></textarea>
					</div>
			</div>

			<button type="submit" class="btn btn-primary">수정 완료</button>

			<!-- 우측 정렬 -->
			</form>
			<%
				}
				%>

		</div>
	</div>


	<!-- 부트스트랩 JS 및 기타 스크립트 파일들을 불러오는 CDN 링크 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-bCFkBRo14VX8fZV0U+KKTaqVXdV4aQk8W5gce1xKKl/SbGlB8foFifBpuFyD7I4M"
		crossorigin="anonymous"></script>
</body>
</html>
