<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰</title>
<!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    .container {
        margin-top: 50px;
    }
    .btn-upload {
        background-color: #6cb2eb;
        color: white;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>글 작성</h2>
        <form action="writepostservlet" method="post">
            <div class="form-group">
                <label for="title"><b>제목:</b></label>
                <input type="text" class="form-control" id="title" name="newtitle" required style="width: 300px;">
            </div>
            <div class="form-group">
                <label for="content">내용:</label>
                <textarea class="form-control" id="content" name="newcontent" rows="6" required style="width: 300px;"></textarea>
            </div>
            <button type="submit" class="btn btn-upload">업로드</button>
        </form>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
