<%@ page import="board.vo.BoardVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        }
        
        .btn-primary:hover {
            text-decoration: underline;
        }
        
        .btn-danger {
            background-color: #dc3545;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            transition: text-decoration 0.3s;
        }
        
        .btn-danger:hover {
            text-decoration: underline;
        }
        
                .btn-tolist {
            background-color: #5a657d;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            transition: text-decoration 0.3s;
        }
        
        .btn-tolist:hover {
            text-decoration: underline;
        }
        
		.button-group {
            position: relative;
            margin-top: 20px; 
            text-align: right;
        }
        
        .button-group .btn {
            margin-right: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1 class="mt-5">게시글 상세보기</h1>
    <div class="post-container">
        <div class="post-header"></div>
        <div class="post-content">
            <% 
            BoardVO postinfo = (BoardVO)session.getAttribute("POSTINFO");
            String username = (String) session.getAttribute("USERNAME");
            String useridstring = (String) session.getAttribute("UserID");
            int userid = Integer.parseInt(useridstring);
            System.out.println("로그인한 유저: "+userid);
            
            if(postinfo != null) {
            %>
            <p><h2><strong>제목:</strong> &nbsp;<%= postinfo.getTitle() %></h2></p>
            <p><strong>작성자:</strong> <%= username %></p>
            <div class="large-box">
                <p><strong>내용:</strong></p>
                <p><%= postinfo.getContent() %></p>
            </div>
            <p><strong>작성시간:</strong> <%= postinfo.getCreated_at() %></p>
            <% } %>
        </div>
    </div>

    <!-- 수정, 삭제 버튼 추가 -->
    
    <%
    // 세션의 user id와 글의 post id 비교하고, 일치할 경우에만 수정,삭제 버튼 보이게 !!!
    
    if (userid == postinfo.getUser_id()){
    %>
    <div class="button-group">
		<!-- 수정 -->
        <a href="editpostservlet?postid=<%= postinfo.getPost_id() %>" class="btn btn-primary">수정</a>
        <!-- 삭제 -->
        <a a href="postdelete?postid=<%= postinfo.getPost_id() %>" class="btn btn-danger">삭제</a>
        </div>
     <%} %>
     <div class="button-group">
        <!-- 목록 -->
        <a a href="boardlistservlet" class="btn btn-tolist">글 목록으로</a>
    </div>
</div>

<!-- 부트스트랩 JS 및 기타 스크립트 파일들을 불러오는 CDN 링크 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-bCFkBRo14VX8fZV0U+KKTaqVXdV4aQk8W5gce1xKKl/SbGlB8foFifBpuFyD7I4M" crossorigin="anonymous"></script>
</body>
</html>
