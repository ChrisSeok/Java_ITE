<%@ page import="board.vo.BoardVO" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시글 상세보기</title>
  <!-- 부트스트랩 CDN 링크 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl5+z9rU+lcTzoIyFkLegdsiK/KOQ/h02KLb5t9iiC" crossorigin="anonymous">
  <style>
    body {
      padding: 20px;
    }
    .post-container {
      margin-bottom: 30px;
    }
    .post-header {
      background-color: #f8f9fa;
      padding: 10px;
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
  </style>
</head>
<body>

  <div class="container">
    <h1 class="mt-5">게시글 상세보기</h1>
    <div class="post-container">
      <div class="post-header">
        <h3>게시글 정보</h3>
      </div>

      <div class="post-content">
        <% 
    		BoardVO postinfo = (BoardVO)session.getAttribute("postinfo");
    		if(postinfo != null) {
    	%>
        <p><strong>게시글 ID:</strong> <%= postinfo.getPost_id() %></p>
        <p><strong>작성자 ID:</strong> <%= postinfo.getUser_id() %></p>
        <p><strong>제목:</strong> <%= postinfo.getTitle() %></p>
        <div class="large-box">
          <p><strong>내용:</strong></p>
          <p><%= postinfo.getContent() %></p>
        </div>
        <p><strong>작성일시:</strong> <%= postinfo.getCreated_at() %></p>
        <% }%>
        
      </div>
    </div>
  </div>

  <!-- 부트스트랩 JS 및 기타 스크립트 파일들을 불러오는 CDN 링크 -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-bCFkBRo14VX8fZV0U+KKTaqVXdV4aQk8W5gce1xKKl/SbGlB8foFifBpuFyD7I4M" crossorigin="anonymous"></script>
</body>
</html>
